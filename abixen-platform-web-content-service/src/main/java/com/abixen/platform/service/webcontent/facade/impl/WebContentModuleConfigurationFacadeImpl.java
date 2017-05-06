/**
 * Copyright (c) 2010-present Abixen Systems. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.abixen.platform.service.webcontent.facade.impl;

import com.abixen.platform.service.webcontent.converter.WebContentModuleConfigurationToWebContentModuleConfigurationDtoConverter;
import com.abixen.platform.service.webcontent.dto.WebContentModuleConfigurationDto;
import com.abixen.platform.service.webcontent.facade.WebContentModuleConfigurationFacade;
import com.abixen.platform.service.webcontent.form.WebContentModuleConfigForm;
import com.abixen.platform.service.webcontent.model.impl.WebContentModuleConfig;
import com.abixen.platform.service.webcontent.service.WebContentModuleConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class WebContentModuleConfigurationFacadeImpl implements WebContentModuleConfigurationFacade {

    private final WebContentModuleConfigurationService webContentModuleConfigurationService;
    private final WebContentModuleConfigurationToWebContentModuleConfigurationDtoConverter converter;

    @Autowired
    public WebContentModuleConfigurationFacadeImpl(WebContentModuleConfigurationService webContentModuleConfigurationService,
                                                   WebContentModuleConfigurationToWebContentModuleConfigurationDtoConverter converter) {
        this.webContentModuleConfigurationService = webContentModuleConfigurationService;
        this.converter = converter;
    }

    @Override
    public WebContentModuleConfigurationDto findWebContentModuleConfiguration(Long moduleId) {
        WebContentModuleConfig webContentModuleConfig = webContentModuleConfigurationService.findWebContentModuleConfig(moduleId);
        WebContentModuleConfigurationDto webContentModuleConfigurationDto = converter.convert(webContentModuleConfig);
        return webContentModuleConfigurationDto;
    }

    @Override
    public WebContentModuleConfigurationDto createWebContentModuleConfiguration(WebContentModuleConfigForm webContentModuleConfigForm) {
        WebContentModuleConfig createdWebContentModuleConfig = webContentModuleConfigurationService.createWebContentModuleConfig(webContentModuleConfigForm);
        WebContentModuleConfigurationDto createdWebContentModuleConfigurationDto = converter.convert(createdWebContentModuleConfig);
        return createdWebContentModuleConfigurationDto;
    }

    @Override
    public WebContentModuleConfigurationDto updateWebContentModuleConfiguration(WebContentModuleConfigForm webContentModuleConfigForm) {
        WebContentModuleConfig updatedWebContentModuleConfig = webContentModuleConfigurationService.updateWebContentModuleConfig(webContentModuleConfigForm);
        WebContentModuleConfigurationDto updatedWebContentModuleConfigurationDto = converter.convert(updatedWebContentModuleConfig);
        return updatedWebContentModuleConfigurationDto;
    }
}
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.portal.taglib.aui.form.extension.sample;

import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.servlet.taglib.TagKeyFactory;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Carlos Sierra Andrés
 */
@Component(
	immediate = true,
	property = {"tagClassName=com.liferay.taglib.aui.FormTag"},
	service = TagKeyFactory.class
)
public class SampleFormTagKeyFactory implements TagKeyFactory {

	@Override
	public String getKey(
		HttpServletRequest request, HttpServletResponse response, Object tag) {

		String portletId = PortalUtil.getPortletId(request);

		if (Validator.isNull(portletId)) {
			return null;
		}

		String name = BeanPropertiesUtil.getStringSilent(tag, "name");

		if (Validator.isNull(name)) {
			return null;
		}

		return portletId.concat(StringPool.DASH).concat(name);
	}

}
/*
 * Copyright (c) 2010-2024 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.openhab.habdroid.ui.activity

import okhttp3.HttpUrl
import org.openhab.habdroid.R
import org.openhab.habdroid.ui.MainActivity

class MainUiWebViewFragment : AbstractWebViewFragment() {
    override val titleRes = R.string.mainmenu_openhab_main_ui
    override val errorMessageRes = R.string.main_ui_error
    override val urlToLoad = "/"
    override val pathForError = "/"
    override val lockDrawer = false
    override val shortcutIcon = R.mipmap.ic_shortcut_main_ui
    override val shortcutAction = MainActivity.ACTION_MAIN_UI_SELECTED

    override fun modifyUrl(orig: HttpUrl): HttpUrl {
        if (orig.host == "myopenhab.org") {
            return orig.newBuilder()
                .host("home.myopenhab.org")
                .build()
        }
        return orig
    }
}

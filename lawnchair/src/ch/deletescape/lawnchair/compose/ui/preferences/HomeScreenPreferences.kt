package ch.deletescape.lawnchair.compose.ui.preferences

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.android.launcher3.R

@Composable
fun HomeScreenPreferences(interactor: PreferenceInteractor) {
    Column {
        PreferenceGroup {
            SwitchPreference(
                checked = interactor.addIconToHome.value,
                onCheckedChange = { interactor.setAddIconToHome(it) },
                label = stringResource(id = R.string.auto_add_shortcuts_label)
            )
        }
        PreferenceGroup(heading = stringResource(id = R.string.grid), showDivider = true) {
            SliderPreference(
                label = stringResource(id = R.string.home_screen_columns),
                value = interactor.workspaceColumns.value,
                onValueChange = { interactor.setWorkspaceColumns(it) },
                steps = 3,
                valueRange = 3.0F..7.0F
            )
            SliderPreference(
                label = stringResource(id = R.string.home_screen_rows),
                value = interactor.workspaceRows.value,
                onValueChange = { interactor.setWorkspaceRows(it) },
                steps = 3,
                valueRange = 3.0F..7.0F
            )
        }
        PreferenceGroup(heading = stringResource(id = R.string.icons), showDivider = true) {
            SliderPreference(
                label = stringResource(id = R.string.icon_size),
                value = interactor.iconSizeFactor.value,
                onValueChange = { interactor.setIconSizeFactor(it) },
                steps = 9,
                valueRange = 0.5F..1.5F,
                showAsPercentage = true
            )
            SliderPreference(
                label = stringResource(id = R.string.label_size),
                value = interactor.textSizeFactor.value,
                onValueChange = { interactor.setTextSizeFactor(it) },
                steps = 9,
                valueRange = 0.5F..1.5F,
                showAsPercentage = true
            )
        }
    }
}

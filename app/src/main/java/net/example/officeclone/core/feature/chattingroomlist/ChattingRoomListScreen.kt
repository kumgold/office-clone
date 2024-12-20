package net.example.officeclone.core.feature.chattingroomlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import net.example.officeclone.R
import net.example.officeclone.core.feature.chattingroom.ChattingRoomScreen
import net.example.officeclone.core.model.ChattingRoom

@Composable
fun ChattingRoomListScreen(
    modifier: Modifier = Modifier,
    viewModel: ChattingRoomListViewModel = hiltViewModel(),
    navigateToChattingRoom: (String) -> Unit
) {
    val chattingRoomList by viewModel.chattingRoomList.collectAsStateWithLifecycle()

    ChattingRoomListScreen(
        modifier = modifier,
        chattingRoomList = chattingRoomList,
        navigateToChattingRoom = navigateToChattingRoom
    )
}

@Composable
private fun ChattingRoomListScreen(
    modifier: Modifier = Modifier,
    chattingRoomList: List<ChattingRoom>,
    navigateToChattingRoom: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.default_margin))
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.chat),
            style = MaterialTheme.typography.titleLarge
        )
        LazyColumn {
            items(chattingRoomList) { room ->
                ChatFeed(
                    room = room,
                    navigateToChattingRoom = navigateToChattingRoom
                )
            }
        }
    }
}

@Composable
private fun ChatFeed(
    modifier: Modifier = Modifier,
    room: ChattingRoom,
    navigateToChattingRoom: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                navigateToChattingRoom(room.id)
            }
            .padding(dimensionResource(id = R.dimen.default_margin)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Gray)
                .padding(dimensionResource(id = R.dimen.default_margin)),
            imageVector = Icons.Default.Person,
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.default_margin)))

        Column {
            Text(
                modifier = Modifier
                    .widthIn(
                        min = 0.dp,
                        max = 300.dp
                    ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = room.name,
                lineHeight = 10.sp,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = 17.sp,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
            Text(
                modifier = Modifier
                    .widthIn(
                        min = 0.dp,
                        max = 300.dp
                    ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                text = "last text",
                lineHeight = 15.sp,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Gray,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
        }
    }
}

@Preview
@Composable
private fun ChatScreenPreview() {
    Surface {
        ChattingRoomListScreen(
            modifier = Modifier,
            chattingRoomList = listOf(
                ChattingRoom(
                    id = "1-11",
                    name = "User Name User Name User Name User Name User Name",
                    memberIdList = listOf()
                ),
                ChattingRoom(
                    id = "1-2",
                    name = "User Name",
                    memberIdList = listOf()
                ),
                ChattingRoom(
                    id = "1-3",
                    name = "User Name",
                    memberIdList = listOf()
                ),
            ),
            navigateToChattingRoom = {}
        )
    }
}
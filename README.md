# BigBrother Plugin

<img src="assets/logo.png" alt="BigBrother" width="128" height="128">

**BigBrother** is a small admin utility plugin for Minecraft servers, offering surveillance features that allow
administrators to monitor and track user interactions with various game objects and actions. From anvils to private
messages, BigBrother keeps admins informed in real time.

## Features

BigBrother sends notifications to admins whenever a user performs specific actions, including:

- **AnvilSpy**: Notifies when a user interacts with an anvil, displaying the item's name before and after the
  interaction.
- **BookSpy**: Notifies when a user writes in a Book and Quill.
- **CommandSpy**: Notifies when any command is executed by a player.
- **PortalSpy**: Notifies when a player travels through a teleport portal (e.g., Nether or End).
- **SignSpy**: Notifies when a player interacts with a sign.
- **SocialSpy**: Notifies when a player sends a private message.

These notifications provide insight into player activities, helping maintain server integrity.

## Commands

The primary command for the **BigBrother** plugin is `/bigbrother`. Use the following subcommands to manage different
functionalities:

| Command           | Description                   |
|-------------------|-------------------------------|
| `reload`          | Reload configurations         |
| `commands <user>` | Toggle command spy for a user |
| `signs <user>`    | Toggle sign spy for a user    |
| `anvils <user>`   | Toggle anvil spy for a user   |
| `books <user>`    | Toggle book spy for a user    |
| `social <user>`   | Toggle social spy for a user  |
| `portals <user>`  | Toggle portal spy for a user  |

### Additional Information

Using `/bigbrother` by itself will enable or disable BigBrother for the user executing the command.

## Permissions

BigBrother includes a robust permission system for fine-grained control over each feature. Below is a list of available
permissions:

| Permission            | Description                                | Default       |
|-----------------------|--------------------------------------------|---------------|
| **bigbrother.***      | Grants access to all BigBrother features.  | Operator (op) |
| **bigbrother.use**    | Allows usage of the `/bigbrother` command. |               |
| **bigbrother.reload** | Allows reloading of the BigBrother plugin. |               |
| **bigbrother.spy.***  | Grants access to all spying features.      |               |

### Specific Spy Permissions

Each spy feature has its own set of permissions, allowing for customized control.

| Permission                              | Description                                    |
|-----------------------------------------|------------------------------------------------|
| **bigbrother.commandspy.***             | Grants access to command spying.               |
| **bigbrother.commandspy.toggle**        | Allows toggling command spy.                   |
| **bigbrother.commandspy.toggle.others** | Allows toggling command spy for other players. |
| **bigbrother.signspy.***                | Grants access to sign spying.                  |
| **bigbrother.signspy.toggle**           | Allows toggling sign spy.                      |
| **bigbrother.signspy.toggle.others**    | Allows toggling sign spy for other players.    |
| **bigbrother.anvilspy.***               | Grants access to anvil spying.                 |
| **bigbrother.anvilspy.toggle**          | Allows toggling anvil spy.                     |
| **bigbrother.anvilspy.toggle.others**   | Allows toggling anvil spy for other players.   |
| **bigbrother.bookspy.***                | Grants access to book spying.                  |
| **bigbrother.bookspy.toggle**           | Allows toggling book spy.                      |
| **bigbrother.bookspy.toggle.others**    | Allows toggling book spy for other players.    |
| **bigbrother.socialspy.***              | Grants access to social spying.                |
| **bigbrother.socialspy.toggle**         | Allows toggling social spy.                    |
| **bigbrother.socialspy.toggle.others**  | Allows toggling social spy for other players.  |
| **bigbrother.portalspy.***              | Grants access to portal spying.                |
| **bigbrother.portalspy.toggle**         | Allows toggling portal spy.                    |
| **bigbrother.portalspy.toggle.others**  | Allows toggling portal spy for other players.  |

## Commands That Trigger Social Spy

The following commands currently trigger Social Spy notifications in BigBrother. At present, these commands are
hardcoded and may be made configurable in future updates:

`/bmsg`, `/bpm`, `/breply`, `/cmi msg`, `/cmi r`, `/cmi reply`, `/cmi t`, `/cmi tell`, `/cmi whisper`, `/emsg`, `/er`,
`/ereply`, `/etell`, `/ewhisper`, `/m`, `/message`, `/mreply`, `/msg`, `/msgchat`, `/pm`, `/pmc`, `/privmsg`, `/r`,
`/reply`, `/t`, `/tell`, `/whisper`

## Installation

1. Download the latest version of BigBrother and place it in your server's `plugins` folder.
2. Restart or reload your server to enable the plugin.
3. Configure settings in `config.yml` as needed.
4. Use `/bigbrother` or `/bb` to access the primary command.

## License

This project is licensed under the [MIT License](LICENSE).

## 📝 Issue Submission Forms

To streamline the process of submitting issues, please use the following forms:

- [Click here to submit a feature request](https://github.com/Chalwk/BigBrother/issues/new?assignees=Chalwk&labels=Feature%2CNeeds+Review&projects=&template=FEATURE_REQUEST.yaml&title=%5BFEATURE%5D+%3Ctitle%3E)
- [Click here to report a bug](https://github.com/Chalwk/BigBrother/issues/new?assignees=Chalwk&labels=Bug%2CNeeds+Triage&projects=&template=BUG_REPORT.yaml&title=%5BBUG%5D+%3Ctitle%3E)

---

*Big Brother is always watching!*
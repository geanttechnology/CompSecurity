.class public Lcom/inc247/ChatSDKResources;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static ACCOUNT_ID:Ljava/lang/String;

.field public static AGENTAVAILABILITY_URL:Ljava/lang/String;

.field public static ANIMATION_TYPE:Ljava/lang/String;

.field public static CUSTOM_MINIMIZE_STATE:Ljava/lang/String;

.field public static CUSTOM_URL_SCHEME:Ljava/lang/String;

.field public static Chatsdk_Config_URL:Ljava/lang/String;

.field public static HALIGN_LANDSCAPE:Ljava/lang/String;

.field public static HALIGN_PORTRAIT:Ljava/lang/String;

.field public static HEIGHT_LANDSCAPE:Ljava/lang/String;

.field public static HEIGHT_PORTRAIT:Ljava/lang/String;

.field public static MAXIMIZE_BUTTON_BACKGROUND:Ljava/lang/String;

.field public static MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

.field public static MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

.field public static MAXIMIZE_BUTTON_TEXTCOLOR:Ljava/lang/String;

.field public static PADDING_BOTTOM_LANDSCAPE:Ljava/lang/String;

.field public static PADDING_BOTTOM_PORTRAIT:Ljava/lang/String;

.field public static PADDING_LEFT_LANDSCAPE:Ljava/lang/String;

.field public static PADDING_LEFT_PORTRAIT:Ljava/lang/String;

.field public static PADDING_RIGHT_LANDSCAPE:Ljava/lang/String;

.field public static PADDING_RIGHT_PORTRAIT:Ljava/lang/String;

.field public static PADDING_TOP_LANDSCAPE:Ljava/lang/String;

.field public static PADDING_TOP_PORTRAIT:Ljava/lang/String;

.field public static QUEUE_ID:Ljava/lang/String;

.field public static URL:Ljava/lang/String;

.field public static VALIGN_LANDSCAPE:Ljava/lang/String;

.field public static VALIGN_PORTRAIT:Ljava/lang/String;

.field public static WIDTH_LANDSCAPE:Ljava/lang/String;

.field public static WIDTH_PORTRAIT:Ljava/lang/String;

.field public static XML_DATA_LOADER_DIALOG:Ljava/lang/String;

.field private static isValid:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 14
    const/4 v0, 0x1

    sput-boolean v0, Lcom/inc247/ChatSDKResources;->isValid:Z

    .line 16
    sput-object v1, Lcom/inc247/ChatSDKResources;->URL:Ljava/lang/String;

    .line 17
    sput-object v1, Lcom/inc247/ChatSDKResources;->Chatsdk_Config_URL:Ljava/lang/String;

    .line 18
    sput-object v1, Lcom/inc247/ChatSDKResources;->AGENTAVAILABILITY_URL:Ljava/lang/String;

    .line 19
    sput-object v1, Lcom/inc247/ChatSDKResources;->ACCOUNT_ID:Ljava/lang/String;

    .line 20
    sput-object v1, Lcom/inc247/ChatSDKResources;->QUEUE_ID:Ljava/lang/String;

    .line 21
    sput-object v1, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

    .line 22
    sput-object v1, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

    .line 23
    sput-object v1, Lcom/inc247/ChatSDKResources;->CUSTOM_MINIMIZE_STATE:Ljava/lang/String;

    .line 24
    sput-object v1, Lcom/inc247/ChatSDKResources;->ANIMATION_TYPE:Ljava/lang/String;

    .line 25
    sput-object v1, Lcom/inc247/ChatSDKResources;->HEIGHT_PORTRAIT:Ljava/lang/String;

    .line 26
    sput-object v1, Lcom/inc247/ChatSDKResources;->HEIGHT_LANDSCAPE:Ljava/lang/String;

    .line 27
    sput-object v1, Lcom/inc247/ChatSDKResources;->WIDTH_PORTRAIT:Ljava/lang/String;

    .line 28
    sput-object v1, Lcom/inc247/ChatSDKResources;->WIDTH_LANDSCAPE:Ljava/lang/String;

    .line 29
    sput-object v1, Lcom/inc247/ChatSDKResources;->HALIGN_PORTRAIT:Ljava/lang/String;

    .line 30
    sput-object v1, Lcom/inc247/ChatSDKResources;->HALIGN_LANDSCAPE:Ljava/lang/String;

    .line 31
    sput-object v1, Lcom/inc247/ChatSDKResources;->VALIGN_PORTRAIT:Ljava/lang/String;

    .line 32
    sput-object v1, Lcom/inc247/ChatSDKResources;->VALIGN_LANDSCAPE:Ljava/lang/String;

    .line 33
    sput-object v1, Lcom/inc247/ChatSDKResources;->PADDING_TOP_PORTRAIT:Ljava/lang/String;

    .line 34
    sput-object v1, Lcom/inc247/ChatSDKResources;->PADDING_TOP_LANDSCAPE:Ljava/lang/String;

    .line 35
    sput-object v1, Lcom/inc247/ChatSDKResources;->PADDING_BOTTOM_PORTRAIT:Ljava/lang/String;

    .line 36
    sput-object v1, Lcom/inc247/ChatSDKResources;->PADDING_BOTTOM_LANDSCAPE:Ljava/lang/String;

    .line 37
    sput-object v1, Lcom/inc247/ChatSDKResources;->PADDING_LEFT_PORTRAIT:Ljava/lang/String;

    .line 38
    sput-object v1, Lcom/inc247/ChatSDKResources;->PADDING_LEFT_LANDSCAPE:Ljava/lang/String;

    .line 39
    sput-object v1, Lcom/inc247/ChatSDKResources;->PADDING_RIGHT_PORTRAIT:Ljava/lang/String;

    .line 40
    sput-object v1, Lcom/inc247/ChatSDKResources;->PADDING_RIGHT_LANDSCAPE:Ljava/lang/String;

    .line 41
    sput-object v1, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_BACKGROUND:Ljava/lang/String;

    .line 42
    sput-object v1, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_TEXTCOLOR:Ljava/lang/String;

    .line 43
    sput-object v1, Lcom/inc247/ChatSDKResources;->CUSTOM_URL_SCHEME:Ljava/lang/String;

    .line 44
    const-string v0, "true"

    sput-object v0, Lcom/inc247/ChatSDKResources;->XML_DATA_LOADER_DIALOG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static initializeValues(Landroid/content/Context;)V
    .locals 33

    .prologue
    .line 53
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 54
    const-string v2, "chatsdk_url"

    const-string v3, "string"

    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 53
    invoke-virtual {v1, v2, v3, v4}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v1

    .line 55
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 56
    const-string v3, "chatsdk_config_url"

    const-string v4, "string"

    .line 57
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    .line 55
    invoke-virtual {v2, v3, v4, v5}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    .line 58
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 59
    const-string v4, "chatsdk_agentavailability_url"

    const-string v5, "string"

    .line 60
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    .line 59
    invoke-virtual {v3, v4, v5, v6}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    .line 61
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 62
    const-string v5, "chatsdk_accountId"

    const-string v6, "string"

    .line 63
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v7

    .line 61
    invoke-virtual {v4, v5, v6, v7}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    .line 64
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 65
    const-string v6, "chatsdk_queueId"

    const-string v7, "string"

    .line 66
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v8

    .line 64
    invoke-virtual {v5, v6, v7, v8}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v5

    .line 68
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    .line 69
    const-string v7, "chatsdk_minimizedbuttonposition_portrait"

    const-string v8, "string"

    .line 70
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v9

    .line 68
    invoke-virtual {v6, v7, v8, v9}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v6

    .line 72
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    .line 73
    const-string v8, "chatsdk_minimizedbuttonposition_landscape"

    const-string v9, "string"

    .line 74
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    .line 72
    invoke-virtual {v7, v8, v9, v10}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v7

    .line 75
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    .line 76
    const-string v9, "chatsdk_customminimizestate"

    const-string v10, "string"

    .line 77
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v11

    .line 76
    invoke-virtual {v8, v9, v10, v11}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v8

    .line 78
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    .line 79
    const-string v10, "chatsdk_animationtype"

    const-string v11, "string"

    .line 80
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v12

    .line 79
    invoke-virtual {v9, v10, v11, v12}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v9

    .line 81
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    .line 82
    const-string v11, "chatsdk_height_portrait"

    const-string v12, "string"

    .line 83
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v13

    .line 82
    invoke-virtual {v10, v11, v12, v13}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v10

    .line 84
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    .line 85
    const-string v12, "chatsdk_height_landscape"

    const-string v13, "string"

    .line 86
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v14

    .line 85
    invoke-virtual {v11, v12, v13, v14}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v11

    .line 87
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    .line 88
    const-string v13, "chatsdk_width_portrait"

    const-string v14, "string"

    .line 89
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v15

    .line 88
    invoke-virtual {v12, v13, v14, v15}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v12

    .line 90
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    .line 91
    const-string v14, "chatsdk_width_landscape"

    const-string v15, "string"

    .line 92
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v16

    .line 91
    invoke-virtual/range {v13 .. v16}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v13

    .line 93
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    .line 94
    const-string v15, "chatsdk_halign_portrait"

    const-string v16, "string"

    .line 95
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v17

    .line 94
    invoke-virtual/range {v14 .. v17}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v14

    .line 96
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v15

    .line 97
    const-string v16, "chatsdk_halign_landscape"

    const-string v17, "string"

    .line 98
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v18

    .line 97
    invoke-virtual/range {v15 .. v18}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v15

    .line 99
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v16

    .line 100
    const-string v17, "chatsdk_valign_portrait"

    const-string v18, "string"

    .line 101
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v19

    .line 100
    invoke-virtual/range {v16 .. v19}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v16

    .line 102
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    .line 103
    const-string v18, "chatsdk_valign_landscape"

    const-string v19, "string"

    .line 104
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v20

    .line 103
    invoke-virtual/range {v17 .. v20}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v17

    .line 105
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    .line 106
    const-string v19, "chatsdk_padding_top_portrait"

    const-string v20, "string"

    .line 107
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v21

    .line 106
    invoke-virtual/range {v18 .. v21}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v18

    .line 108
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v19

    .line 109
    const-string v20, "chatsdk_padding_top_landscape"

    const-string v21, "string"

    .line 110
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v22

    .line 109
    invoke-virtual/range {v19 .. v22}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v19

    .line 111
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    .line 112
    const-string v21, "chatsdk_padding_bottom_portrait"

    const-string v22, "string"

    .line 113
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v23

    .line 112
    invoke-virtual/range {v20 .. v23}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v20

    .line 114
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v21

    .line 115
    const-string v22, "chatsdk_padding_bottom_landscape"

    const-string v23, "string"

    .line 116
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v24

    .line 115
    invoke-virtual/range {v21 .. v24}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v21

    .line 117
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v22

    .line 118
    const-string v23, "chatsdk_padding_left_portrait"

    const-string v24, "string"

    .line 119
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v25

    .line 118
    invoke-virtual/range {v22 .. v25}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v22

    .line 120
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v23

    .line 121
    const-string v24, "chatsdk_padding_left_landscape"

    const-string v25, "string"

    .line 122
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v26

    .line 121
    invoke-virtual/range {v23 .. v26}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v23

    .line 123
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v24

    .line 124
    const-string v25, "chatsdk_padding_right_portrait"

    const-string v26, "string"

    .line 125
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v27

    .line 124
    invoke-virtual/range {v24 .. v27}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v24

    .line 126
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v25

    .line 127
    const-string v26, "chatsdk_padding_right_landscape"

    const-string v27, "string"

    .line 128
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v28

    .line 127
    invoke-virtual/range {v25 .. v28}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v25

    .line 129
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v26

    .line 130
    const-string v27, "chatsdk_minimizedbutton_background"

    const-string v28, "string"

    .line 131
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v29

    .line 130
    invoke-virtual/range {v26 .. v29}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v26

    .line 132
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v27

    .line 133
    const-string v28, "chatsdk_minimizedbutton_textcolor"

    const-string v29, "string"

    .line 134
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v30

    .line 133
    invoke-virtual/range {v27 .. v30}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v27

    .line 135
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v28

    .line 136
    const-string v29, "chatsdk_urlscheme"

    const-string v30, "string"

    .line 137
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v31

    .line 136
    invoke-virtual/range {v28 .. v31}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v28

    .line 138
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v29

    .line 139
    const-string v30, "chatsdk_xml_loader_dialog"

    const-string v31, "string"

    .line 140
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v32

    .line 139
    invoke-virtual/range {v29 .. v32}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v29

    .line 142
    if-eqz v1, :cond_0

    .line 143
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v30

    sput-object v30, Lcom/inc247/ChatSDKResources;->URL:Ljava/lang/String;

    .line 145
    :cond_0
    if-eqz v2, :cond_1

    .line 146
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->Chatsdk_Config_URL:Ljava/lang/String;

    .line 150
    :cond_1
    if-eqz v3, :cond_2

    .line 151
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 152
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 151
    sput-object v2, Lcom/inc247/ChatSDKResources;->AGENTAVAILABILITY_URL:Ljava/lang/String;

    .line 155
    :cond_2
    if-eqz v4, :cond_3

    .line 156
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->ACCOUNT_ID:Ljava/lang/String;

    .line 159
    :cond_3
    if-eqz v5, :cond_4

    .line 160
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->QUEUE_ID:Ljava/lang/String;

    .line 162
    :cond_4
    if-eqz v6, :cond_5

    .line 164
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 163
    sput-object v2, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

    .line 167
    :cond_5
    if-eqz v7, :cond_6

    .line 169
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 168
    sput-object v2, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

    .line 172
    :cond_6
    if-eqz v8, :cond_7

    .line 173
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 174
    invoke-virtual {v2, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 173
    sput-object v2, Lcom/inc247/ChatSDKResources;->CUSTOM_MINIMIZE_STATE:Ljava/lang/String;

    .line 176
    :cond_7
    if-eqz v9, :cond_8

    .line 177
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->ANIMATION_TYPE:Ljava/lang/String;

    .line 180
    :cond_8
    if-eqz v10, :cond_9

    .line 181
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->HEIGHT_PORTRAIT:Ljava/lang/String;

    .line 184
    :cond_9
    if-eqz v11, :cond_a

    .line 185
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->HEIGHT_LANDSCAPE:Ljava/lang/String;

    .line 188
    :cond_a
    if-eqz v12, :cond_b

    .line 189
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v12}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->WIDTH_PORTRAIT:Ljava/lang/String;

    .line 193
    :cond_b
    if-eqz v13, :cond_c

    .line 194
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v13}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->WIDTH_LANDSCAPE:Ljava/lang/String;

    .line 197
    :cond_c
    if-eqz v14, :cond_d

    .line 198
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v14}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->HALIGN_PORTRAIT:Ljava/lang/String;

    .line 201
    :cond_d
    if-eqz v15, :cond_e

    .line 202
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v15}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->HALIGN_LANDSCAPE:Ljava/lang/String;

    .line 205
    :cond_e
    if-eqz v16, :cond_f

    .line 206
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    move/from16 v0, v16

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->VALIGN_PORTRAIT:Ljava/lang/String;

    .line 209
    :cond_f
    if-eqz v17, :cond_10

    .line 210
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    move/from16 v0, v17

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->VALIGN_LANDSCAPE:Ljava/lang/String;

    .line 213
    :cond_10
    if-eqz v18, :cond_11

    .line 214
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    move/from16 v0, v18

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_TOP_PORTRAIT:Ljava/lang/String;

    .line 217
    :cond_11
    if-eqz v19, :cond_12

    .line 218
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 219
    move/from16 v0, v19

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 218
    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_TOP_LANDSCAPE:Ljava/lang/String;

    .line 221
    :cond_12
    if-eqz v20, :cond_13

    .line 222
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 223
    move/from16 v0, v20

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 222
    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_BOTTOM_PORTRAIT:Ljava/lang/String;

    .line 225
    :cond_13
    if-eqz v21, :cond_14

    .line 226
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 227
    move/from16 v0, v21

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 226
    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_BOTTOM_LANDSCAPE:Ljava/lang/String;

    .line 229
    :cond_14
    if-eqz v22, :cond_15

    .line 230
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 231
    move/from16 v0, v22

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 230
    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_LEFT_PORTRAIT:Ljava/lang/String;

    .line 233
    :cond_15
    if-eqz v23, :cond_16

    .line 234
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 235
    move/from16 v0, v23

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 234
    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_LEFT_LANDSCAPE:Ljava/lang/String;

    .line 237
    :cond_16
    if-eqz v24, :cond_17

    .line 238
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 239
    move/from16 v0, v24

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 238
    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_RIGHT_PORTRAIT:Ljava/lang/String;

    .line 241
    :cond_17
    if-eqz v25, :cond_18

    .line 242
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 243
    move/from16 v0, v25

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 242
    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_RIGHT_LANDSCAPE:Ljava/lang/String;

    .line 245
    :cond_18
    if-eqz v26, :cond_19

    .line 246
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 247
    move/from16 v0, v26

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 246
    sput-object v2, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_BACKGROUND:Ljava/lang/String;

    .line 249
    :cond_19
    if-eqz v27, :cond_1a

    .line 250
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 251
    move/from16 v0, v27

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 250
    sput-object v2, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_TEXTCOLOR:Ljava/lang/String;

    .line 253
    :cond_1a
    if-eqz v28, :cond_1b

    .line 254
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    move/from16 v0, v28

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->CUSTOM_URL_SCHEME:Ljava/lang/String;

    .line 258
    :cond_1b
    if-eqz v29, :cond_1c

    .line 259
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 260
    move/from16 v0, v29

    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 259
    sput-object v2, Lcom/inc247/ChatSDKResources;->XML_DATA_LOADER_DIALOG:Ljava/lang/String;

    .line 263
    :cond_1c
    sget-object v2, Lcom/inc247/ChatSDKResources;->WIDTH_PORTRAIT:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->WIDTH_PORTRAIT:Ljava/lang/String;

    .line 264
    sget-object v2, Lcom/inc247/ChatSDKResources;->HEIGHT_PORTRAIT:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->HEIGHT_PORTRAIT:Ljava/lang/String;

    .line 265
    sget-object v2, Lcom/inc247/ChatSDKResources;->PADDING_TOP_PORTRAIT:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_TOP_PORTRAIT:Ljava/lang/String;

    .line 266
    sget-object v2, Lcom/inc247/ChatSDKResources;->PADDING_BOTTOM_PORTRAIT:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_BOTTOM_PORTRAIT:Ljava/lang/String;

    .line 267
    sget-object v2, Lcom/inc247/ChatSDKResources;->PADDING_LEFT_PORTRAIT:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_LEFT_PORTRAIT:Ljava/lang/String;

    .line 268
    sget-object v2, Lcom/inc247/ChatSDKResources;->PADDING_RIGHT_PORTRAIT:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_RIGHT_PORTRAIT:Ljava/lang/String;

    .line 270
    sget-object v2, Lcom/inc247/ChatSDKResources;->WIDTH_LANDSCAPE:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->WIDTH_LANDSCAPE:Ljava/lang/String;

    .line 271
    sget-object v2, Lcom/inc247/ChatSDKResources;->HEIGHT_LANDSCAPE:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->HEIGHT_LANDSCAPE:Ljava/lang/String;

    .line 272
    sget-object v2, Lcom/inc247/ChatSDKResources;->PADDING_TOP_LANDSCAPE:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_TOP_LANDSCAPE:Ljava/lang/String;

    .line 273
    sget-object v2, Lcom/inc247/ChatSDKResources;->PADDING_BOTTOM_LANDSCAPE:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_BOTTOM_LANDSCAPE:Ljava/lang/String;

    .line 274
    sget-object v2, Lcom/inc247/ChatSDKResources;->PADDING_LEFT_LANDSCAPE:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_LEFT_LANDSCAPE:Ljava/lang/String;

    .line 275
    sget-object v2, Lcom/inc247/ChatSDKResources;->PADDING_RIGHT_LANDSCAPE:Ljava/lang/String;

    const-string v9, "%"

    const-string v10, ""

    invoke-virtual {v2, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/inc247/ChatSDKResources;->PADDING_RIGHT_LANDSCAPE:Ljava/lang/String;

    .line 278
    sget-object v2, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

    const-string v9, "middle-left"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1d

    sget-object v2, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_PORTRAIT:Ljava/lang/String;

    .line 279
    const-string v9, "middle-right"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1d

    .line 280
    const/4 v2, 0x0

    sput-boolean v2, Lcom/inc247/ChatSDKResources;->isValid:Z

    .line 283
    :cond_1d
    sget-object v2, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

    .line 284
    const-string v9, "middle-left"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1e

    sget-object v2, Lcom/inc247/ChatSDKResources;->MAXIMIZE_BUTTON_POSITION_LANDSCAPE:Ljava/lang/String;

    .line 285
    const-string v9, "middle-right"

    invoke-virtual {v2, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1e

    .line 286
    const/4 v2, 0x0

    sput-boolean v2, Lcom/inc247/ChatSDKResources;->isValid:Z

    .line 292
    :cond_1e
    if-eqz v1, :cond_1f

    if-eqz v3, :cond_1f

    .line 293
    if-eqz v4, :cond_1f

    if-eqz v5, :cond_1f

    .line 294
    if-eqz v6, :cond_1f

    .line 295
    if-eqz v7, :cond_1f

    .line 296
    if-eqz v8, :cond_1f

    .line 297
    if-eqz v26, :cond_1f

    .line 298
    if-nez v27, :cond_20

    .line 299
    :cond_1f
    const/4 v1, 0x0

    sput-boolean v1, Lcom/inc247/ChatSDKResources;->isValid:Z

    .line 302
    :cond_20
    return-void
.end method

.method public static isXMLValid()Z
    .locals 1

    .prologue
    .line 305
    sget-boolean v0, Lcom/inc247/ChatSDKResources;->isValid:Z

    return v0
.end method

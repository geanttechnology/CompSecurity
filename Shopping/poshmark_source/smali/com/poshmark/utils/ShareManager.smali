.class public Lcom/poshmark/utils/ShareManager;
.super Ljava/lang/Object;
.source "ShareManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/ShareManager$1;,
        Lcom/poshmark/utils/ShareManager$SHARE_MODE;,
        Lcom/poshmark/utils/ShareManager$SHARE_TYPE;,
        Lcom/poshmark/utils/ShareManager$SingletonHolder;
    }
.end annotation


# static fields
.field public static EXTERNAL_SHARE_STATE_CANCELLED:Ljava/lang/String;

.field public static EXTERNAL_SHARE_STATE_INITIALED:Ljava/lang/String;

.field public static EXTERNAL_SHARE_STATE_SUCCESS:Ljava/lang/String;


# instance fields
.field callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field content:Lcom/poshmark/utils/sharing/PMShareContent;

.field context:Landroid/content/Context;

.field mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

.field private type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 79
    const-string v0, "i"

    sput-object v0, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_INITIALED:Ljava/lang/String;

    .line 80
    const-string v0, "f"

    sput-object v0, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_CANCELLED:Ljava/lang/String;

    .line 81
    const-string v0, "c"

    sput-object v0, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_SUCCESS:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    new-instance v0, Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-direct {v0}, Lcom/poshmark/utils/sharing/PMShareContent;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    .line 90
    return-void
.end method

.method synthetic constructor <init>(Lcom/poshmark/utils/ShareManager$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/poshmark/utils/ShareManager$1;

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/poshmark/utils/ShareManager;
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lcom/poshmark/utils/ShareManager$SingletonHolder;->INSTANCE:Lcom/poshmark/utils/ShareManager;

    return-object v0
.end method

.method private getMessageEditorScreenNameForAnalytics()Ljava/lang/String;
    .locals 2

    .prologue
    .line 294
    sget-object v0, Lcom/poshmark/utils/ShareManager$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 302
    :pswitch_0
    const-string v0, ""

    :goto_0
    return-object v0

    .line 296
    :pswitch_1
    const-string v0, "facebook_share_message_screen"

    goto :goto_0

    .line 298
    :pswitch_2
    const-string v0, "tumblr_share_message_screen"

    goto :goto_0

    .line 300
    :pswitch_3
    const-string v0, "twitter_share_message_screen"

    goto :goto_0

    .line 294
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method


# virtual methods
.method public deInit()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 110
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 111
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager;->context:Landroid/content/Context;

    .line 112
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/PMShareContent;->reset()V

    .line 113
    return-void
.end method

.method public doEmailShare()V
    .locals 1

    .prologue
    .line 260
    new-instance v0, Lcom/poshmark/utils/sharing/EmailShareStateMachine;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/EmailShareStateMachine;-><init>(Lcom/poshmark/utils/ShareManager;)V

    .line 261
    .local v0, "stateMachine":Lcom/poshmark/utils/sharing/EmailShareStateMachine;
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/EmailShareStateMachine;->init()V

    .line 262
    return-void
.end method

.method public doFBMessengerShare()V
    .locals 1

    .prologue
    .line 270
    new-instance v0, Lcom/poshmark/utils/sharing/FbMessengerStateMachine;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/FbMessengerStateMachine;-><init>(Lcom/poshmark/utils/ShareManager;)V

    .line 271
    .local v0, "stateMachine":Lcom/poshmark/utils/sharing/FbMessengerStateMachine;
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/FbMessengerStateMachine;->init()V

    .line 272
    return-void
.end method

.method public doFbShareViaServer()V
    .locals 1

    .prologue
    .line 246
    new-instance v0, Lcom/poshmark/utils/sharing/FbServerStateMachine;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/FbServerStateMachine;-><init>(Lcom/poshmark/utils/ShareManager;)V

    .line 247
    .local v0, "stateMachine":Lcom/poshmark/utils/sharing/FbServerStateMachine;
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/FbServerStateMachine;->init()V

    .line 248
    return-void
.end method

.method public doFbShareViaShareDialog()V
    .locals 1

    .prologue
    .line 251
    new-instance v0, Lcom/poshmark/utils/sharing/FbDialogStateMachine;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/FbDialogStateMachine;-><init>(Lcom/poshmark/utils/ShareManager;)V

    .line 252
    .local v0, "stateMachine":Lcom/poshmark/utils/sharing/FbDialogStateMachine;
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/FbDialogStateMachine;->init()V

    .line 253
    return-void
.end method

.method public doPinterestShare()V
    .locals 1

    .prologue
    .line 255
    new-instance v0, Lcom/poshmark/utils/sharing/PinterestShareStateMachine;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/PinterestShareStateMachine;-><init>(Lcom/poshmark/utils/ShareManager;)V

    .line 256
    .local v0, "stateMachine":Lcom/poshmark/utils/sharing/PinterestShareStateMachine;
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/PinterestShareStateMachine;->init()V

    .line 257
    return-void
.end method

.method public doSMSShare()V
    .locals 1

    .prologue
    .line 265
    new-instance v0, Lcom/poshmark/utils/sharing/SMSShareStateMachine;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/SMSShareStateMachine;-><init>(Lcom/poshmark/utils/ShareManager;)V

    .line 266
    .local v0, "stateMachine":Lcom/poshmark/utils/sharing/SMSShareStateMachine;
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/SMSShareStateMachine;->init()V

    .line 267
    return-void
.end method

.method public doTumblrShare()V
    .locals 1

    .prologue
    .line 280
    new-instance v0, Lcom/poshmark/utils/sharing/TumblrServerShareStateMachine;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/TumblrServerShareStateMachine;-><init>(Lcom/poshmark/utils/ShareManager;)V

    .line 281
    .local v0, "stateMachine":Lcom/poshmark/utils/sharing/TumblrServerShareStateMachine;
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/TumblrServerShareStateMachine;->init()V

    .line 282
    return-void
.end method

.method public doTwitterShare()V
    .locals 1

    .prologue
    .line 275
    new-instance v0, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;-><init>(Lcom/poshmark/utils/ShareManager;)V

    .line 276
    .local v0, "stateMachine":Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/TwitterServerShareStateMachine;->init()V

    .line 277
    return-void
.end method

.method public getExternalShareCode()Ljava/lang/String;
    .locals 3

    .prologue
    .line 159
    const/4 v0, 0x0

    .line 160
    .local v0, "code":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/ShareManager$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 186
    const-string v0, ""

    .line 189
    :goto_0
    return-object v0

    .line 162
    :pswitch_0
    const-string v0, "fbd"

    .line 163
    goto :goto_0

    .line 165
    :pswitch_1
    const-string v0, "fb"

    .line 166
    goto :goto_0

    .line 168
    :pswitch_2
    const-string v0, "fbm"

    .line 169
    goto :goto_0

    .line 171
    :pswitch_3
    const-string v0, "tm"

    .line 172
    goto :goto_0

    .line 174
    :pswitch_4
    const-string v0, "tw"

    .line 175
    goto :goto_0

    .line 177
    :pswitch_5
    const-string v0, "email"

    .line 178
    goto :goto_0

    .line 180
    :pswitch_6
    const-string v0, "pnd"

    .line 181
    goto :goto_0

    .line 183
    :pswitch_7
    const-string v0, "sms"

    .line 184
    goto :goto_0

    .line 160
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public getFragment()Lcom/poshmark/ui/fragments/PMFragment;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    return-object v0
.end method

.method public getReferralData()Lcom/poshmark/data_model/models/Referral;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getReferralData()Lcom/poshmark/data_model/models/Referral;

    move-result-object v0

    return-object v0
.end method

.method public getShareContent()Lcom/poshmark/utils/sharing/PMShareContent;
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    return-object v0
.end method

.method public getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    return-object v0
.end method

.method public getShareType()Lcom/poshmark/utils/ShareManager$SHARE_TYPE;
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    return-object v0
.end method

.method public getTitleString()Ljava/lang/String;
    .locals 3

    .prologue
    const v2, 0x7f060157

    .line 230
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_0

    .line 231
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->context:Landroid/content/Context;

    const v1, 0x7f060252

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 242
    :goto_0
    return-object v0

    .line 232
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_1

    .line 233
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->context:Landroid/content/Context;

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 234
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_2

    .line 235
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->context:Landroid/content/Context;

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 236
    :cond_2
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_3

    .line 237
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->context:Landroid/content/Context;

    const v1, 0x7f060250

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 238
    :cond_3
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_4

    .line 239
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->context:Landroid/content/Context;

    const v1, 0x7f060254

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 240
    :cond_4
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_5

    .line 241
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->context:Landroid/content/Context;

    const v1, 0x7f06024f

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 242
    :cond_5
    const-string v0, ""

    goto :goto_0
.end method

.method public getUserMessage()V
    .locals 6

    .prologue
    .line 306
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 307
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "MESSAGE"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 308
    const-string v2, "PLACEHOLDER"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getPlaceHolderString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 309
    const-string v2, "ANALYTICS_PAGE_NAME"

    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager;->getMessageEditorScreenNameForAnalytics()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 311
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->context:Landroid/content/Context;

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 312
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 313
    const-class v2, Lcom/poshmark/ui/fragments/MessageEditorFragment;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const/16 v5, 0xc

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 316
    :cond_0
    return-void
.end method

.method public init(Landroid/content/Context;Lcom/poshmark/utils/ShareManager$SHARE_MODE;Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mode"    # Lcom/poshmark/utils/ShareManager$SHARE_MODE;
    .param p3, "callingFragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager;->context:Landroid/content/Context;

    .line 94
    iput-object p2, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 95
    iput-object p3, p0, Lcom/poshmark/utils/ShareManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 96
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0, p2}, Lcom/poshmark/utils/sharing/PMShareContent;->setShareMode(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)V

    .line 97
    return-void
.end method

.method public setBrand(Lcom/poshmark/data_model/models/Brand;)V
    .locals 1
    .param p1, "brand"    # Lcom/poshmark/data_model/models/Brand;

    .prologue
    .line 222
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/sharing/PMShareContent;->setBrand(Lcom/poshmark/data_model/models/Brand;)V

    .line 223
    return-void
.end method

.method public setListingItem(Lcom/poshmark/data_model/models/ListingSocial;)V
    .locals 1
    .param p1, "listingItem"    # Lcom/poshmark/data_model/models/ListingSocial;

    .prologue
    .line 198
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/sharing/PMShareContent;->setListing(Lcom/poshmark/data_model/models/ListingSummary;)V

    .line 199
    return-void
.end method

.method public setPartyEvent(Lcom/poshmark/data_model/models/PartyEvent;)V
    .locals 1
    .param p1, "event"    # Lcom/poshmark/data_model/models/PartyEvent;

    .prologue
    .line 210
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/sharing/PMShareContent;->setParty(Lcom/poshmark/data_model/models/PartyEvent;)V

    .line 211
    return-void
.end method

.method public setReferralData(Lcom/poshmark/data_model/models/Referral;)V
    .locals 1
    .param p1, "data"    # Lcom/poshmark/data_model/models/Referral;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/sharing/PMShareContent;->setReferralData(Lcom/poshmark/data_model/models/Referral;)V

    .line 117
    return-void
.end method

.method public setShareContent(Lcom/poshmark/utils/sharing/ServerShareMessages;)V
    .locals 1
    .param p1, "data"    # Lcom/poshmark/utils/sharing/ServerShareMessages;

    .prologue
    .line 202
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/sharing/PMShareContent;->setServerShareContent(Lcom/poshmark/utils/sharing/ServerShareMessages;)V

    .line 203
    return-void
.end method

.method public setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V
    .locals 1
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 193
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .line 194
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/sharing/PMShareContent;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 195
    return-void
.end method

.method public setShowroom(Lcom/poshmark/data_model/models/Showroom;)V
    .locals 1
    .param p1, "showroom"    # Lcom/poshmark/data_model/models/Showroom;

    .prologue
    .line 218
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/sharing/PMShareContent;->setShowroom(Lcom/poshmark/data_model/models/Showroom;)V

    .line 219
    return-void
.end method

.method public setUserProfile(Lcom/poshmark/user/UserInfoDetails;)V
    .locals 1
    .param p1, "userInfo"    # Lcom/poshmark/user/UserInfoDetails;

    .prologue
    .line 214
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v0, p1}, Lcom/poshmark/utils/sharing/PMShareContent;->setUser(Lcom/poshmark/user/UserInfoDetails;)V

    .line 215
    return-void
.end method

.method public shareToEventWithId()V
    .locals 1

    .prologue
    .line 289
    new-instance v0, Lcom/poshmark/utils/sharing/ShareToPartyStateMachine;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/ShareToPartyStateMachine;-><init>(Lcom/poshmark/utils/ShareManager;)V

    .line 290
    .local v0, "stateMachine":Lcom/poshmark/utils/sharing/ShareToPartyStateMachine;
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/ShareToPartyStateMachine;->init()V

    .line 291
    return-void
.end method

.method public shareToFollowers()V
    .locals 1

    .prologue
    .line 284
    new-instance v0, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;-><init>(Lcom/poshmark/utils/ShareManager;)V

    .line 285
    .local v0, "stateMachine":Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;
    invoke-virtual {v0}, Lcom/poshmark/utils/sharing/ShareToFollowersStateMachine;->init()V

    .line 286
    return-void
.end method

.method public trackExternalShareOnPM(Ljava/lang/String;)V
    .locals 10
    .param p1, "shareState"    # Ljava/lang/String;

    .prologue
    .line 383
    const/4 v0, 0x0

    .line 384
    .local v0, "action":Ljava/lang/String;
    const/4 v5, 0x0

    .line 385
    .local v5, "medium":Ljava/lang/String;
    const/4 v6, 0x0

    .line 386
    .local v6, "objectId":Ljava/lang/String;
    const/4 v7, 0x0

    .line 388
    .local v7, "screen":Ljava/lang/String;
    sget-object v8, Lcom/poshmark/utils/ShareManager$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v9, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v9}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v9

    aget v8, v8, v9

    packed-switch v8, :pswitch_data_0

    .line 546
    :cond_0
    :goto_0
    :pswitch_0
    if-eqz v0, :cond_1

    if-eqz v5, :cond_1

    if-eqz v6, :cond_1

    if-eqz v7, :cond_1

    .line 547
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 548
    .local v3, "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v8, Lcom/poshmark/http/api/PMApi;->PMTrackingActionKey:Ljava/lang/String;

    invoke-virtual {v3, v8, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 549
    sget-object v8, Lcom/poshmark/http/api/PMApi;->PMTrackingMediumKey:Ljava/lang/String;

    invoke-virtual {v3, v8, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 550
    sget-object v8, Lcom/poshmark/http/api/PMApi;->PMTrackingObjectIdKey:Ljava/lang/String;

    invoke-virtual {v3, v8, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 551
    sget-object v8, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenKey:Ljava/lang/String;

    invoke-virtual {v3, v8, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 553
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 554
    .local v1, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 555
    .local v2, "gson":Lcom/google/gson/Gson;
    const-class v8, Ljava/util/HashMap;

    instance-of v9, v2, Lcom/google/gson/Gson;

    if-nez v9, :cond_26

    invoke-virtual {v2, v3, v8}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    .line 558
    .end local v2    # "gson":Lcom/google/gson/Gson;
    .local v4, "jsonStr":Ljava/lang/String;
    :goto_1
    invoke-static {v4, p1}, Lcom/poshmark/http/api/PMApi;->trackExternalShare(Ljava/lang/String;Ljava/lang/String;)V

    .line 560
    .end local v1    # "b":Lcom/google/gson/GsonBuilder;
    .end local v3    # "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4    # "jsonStr":Ljava/lang/String;
    :cond_1
    return-void

    .line 390
    :pswitch_1
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareListing:Ljava/lang/String;

    .line 391
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v8}, Lcom/poshmark/utils/sharing/PMShareContent;->getListing()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v6

    .line 392
    sget-object v7, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenListingShare:Ljava/lang/String;

    .line 393
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_2

    .line 394
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    goto :goto_0

    .line 396
    :cond_2
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_3

    .line 397
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto :goto_0

    .line 399
    :cond_3
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_4

    .line 400
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto :goto_0

    .line 402
    :cond_4
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_5

    .line 403
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto :goto_0

    .line 405
    :cond_5
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_6

    .line 406
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto :goto_0

    .line 408
    :cond_6
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_7

    .line 409
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto :goto_0

    .line 411
    :cond_7
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_0

    .line 412
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 416
    :pswitch_2
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareCloset:Ljava/lang/String;

    .line 417
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v8}, Lcom/poshmark/utils/sharing/PMShareContent;->getUser()Lcom/poshmark/user/UserInfoDetails;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v6

    .line 418
    sget-object v7, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenClosetShare:Ljava/lang/String;

    .line 419
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_8

    .line 420
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    goto/16 :goto_0

    .line 422
    :cond_8
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_9

    .line 423
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto/16 :goto_0

    .line 425
    :cond_9
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_a

    .line 426
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 428
    :cond_a
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_b

    .line 429
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto/16 :goto_0

    .line 431
    :cond_b
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_c

    .line 432
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto/16 :goto_0

    .line 434
    :cond_c
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_0

    .line 435
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto/16 :goto_0

    .line 440
    :pswitch_3
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareShowroom:Ljava/lang/String;

    .line 441
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v8}, Lcom/poshmark/utils/sharing/PMShareContent;->getShowroom()Lcom/poshmark/data_model/models/Showroom;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v6

    .line 442
    sget-object v7, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenShowroomShare:Ljava/lang/String;

    .line 443
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_d

    .line 444
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    goto/16 :goto_0

    .line 446
    :cond_d
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_e

    .line 447
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto/16 :goto_0

    .line 449
    :cond_e
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_f

    .line 450
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 452
    :cond_f
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_10

    .line 453
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto/16 :goto_0

    .line 455
    :cond_10
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_11

    .line 456
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto/16 :goto_0

    .line 458
    :cond_11
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_12

    .line 459
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto/16 :goto_0

    .line 461
    :cond_12
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_0

    .line 462
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 467
    :pswitch_4
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareReferralCode:Ljava/lang/String;

    .line 468
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v6

    .line 469
    sget-object v7, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenReferralCodeShare:Ljava/lang/String;

    .line 470
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_13

    .line 471
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    goto/16 :goto_0

    .line 473
    :cond_13
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_14

    .line 474
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto/16 :goto_0

    .line 476
    :cond_14
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_15

    .line 477
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 479
    :cond_15
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_16

    .line 480
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto/16 :goto_0

    .line 482
    :cond_16
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_17

    .line 483
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto/16 :goto_0

    .line 485
    :cond_17
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_18

    .line 486
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto/16 :goto_0

    .line 488
    :cond_18
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_0

    .line 489
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 494
    :pswitch_5
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareBrand:Ljava/lang/String;

    .line 495
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v6

    .line 496
    sget-object v7, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenBrandShare:Ljava/lang/String;

    .line 497
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_1a

    .line 498
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    .line 520
    :cond_19
    :goto_2
    :pswitch_6
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareBrand:Ljava/lang/String;

    .line 521
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v6

    .line 522
    sget-object v7, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenJustInBrandShare:Ljava/lang/String;

    .line 523
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_20

    .line 524
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    goto/16 :goto_0

    .line 500
    :cond_1a
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_1b

    .line 501
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto :goto_2

    .line 503
    :cond_1b
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_1c

    .line 504
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto :goto_2

    .line 506
    :cond_1c
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_1d

    .line 507
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto :goto_2

    .line 509
    :cond_1d
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_1e

    .line 510
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto :goto_2

    .line 512
    :cond_1e
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_1f

    .line 513
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto :goto_2

    .line 515
    :cond_1f
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_19

    .line 516
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto :goto_2

    .line 526
    :cond_20
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_21

    .line 527
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto/16 :goto_0

    .line 529
    :cond_21
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_22

    .line 530
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 532
    :cond_22
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_23

    .line 533
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto/16 :goto_0

    .line 535
    :cond_23
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_24

    .line 536
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto/16 :goto_0

    .line 538
    :cond_24
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_25

    .line 539
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto/16 :goto_0

    .line 541
    :cond_25
    iget-object v8, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v9, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v8, v9, :cond_0

    .line 542
    sget-object v5, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 555
    .restart local v1    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    .restart local v3    # "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_26
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v3, v8}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_1

    .line 388
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_5
        :pswitch_4
        :pswitch_6
    .end packed-switch
.end method

.method public trackShareEvent()V
    .locals 5

    .prologue
    .line 319
    const/4 v1, 0x0

    .line 320
    .local v1, "label":Ljava/lang/String;
    const/4 v2, 0x0

    .line 321
    .local v2, "screenName":Ljava/lang/String;
    const/4 v0, 0x0

    .line 323
    .local v0, "eventCategory":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v3, v4, :cond_9

    .line 324
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getListing()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getListing()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 325
    const-string v2, "share_listing_options_screen"

    .line 326
    const-string v0, "listing"

    .line 345
    :cond_0
    :goto_0
    if-eqz v1, :cond_8

    .line 346
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v3, v4, :cond_1

    .line 347
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_listing_facebook"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 348
    :cond_1
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->TW_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v3, v4, :cond_2

    .line 349
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_listing_twitter"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 350
    :cond_2
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->TM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v3, v4, :cond_3

    .line 351
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_listing_tumblr"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 352
    :cond_3
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v3, v4, :cond_4

    .line 353
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_pinterest"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 354
    :cond_4
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v3, v4, :cond_5

    .line 355
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_listing_email"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 356
    :cond_5
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v3, v4, :cond_6

    .line 357
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_listing_sms"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    :cond_6
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v3, v4, :cond_7

    .line 359
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_listing_fbmessenger"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 360
    :cond_7
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v3, v4, :cond_8

    .line 361
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_listing_fb_dialog"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 363
    :cond_8
    return-void

    .line 327
    :cond_9
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v3, v4, :cond_a

    .line 328
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 329
    const-string v2, "referral_screen"

    .line 330
    const-string v0, "user"

    goto/16 :goto_0

    .line 331
    :cond_a
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v3, v4, :cond_b

    .line 332
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getParty()Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v4}, Lcom/poshmark/utils/sharing/PMShareContent;->getParty()Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 333
    const-string v2, "share_party_options_screen"

    .line 334
    const-string v0, "party"

    goto/16 :goto_0

    .line 335
    :cond_b
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-eq v3, v4, :cond_c

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND_JUSTIN:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v3, v4, :cond_d

    .line 336
    :cond_c
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getBrand()Lcom/poshmark/data_model/models/Brand;

    move-result-object v3

    iget-object v1, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    .line 337
    const-string v2, "share_brand_options_screen"

    .line 338
    const-string v0, "brand"

    goto/16 :goto_0

    .line 339
    :cond_d
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v3, v4, :cond_0

    .line 340
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getShowroom()Lcom/poshmark/data_model/models/Showroom;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v1

    .line 341
    const-string v2, "share_showroom_options_screen"

    .line 342
    const-string v0, "showroom"

    goto/16 :goto_0
.end method

.method public trackShareFailedEvent()V
    .locals 5

    .prologue
    .line 366
    const/4 v0, 0x0

    .line 367
    .local v0, "label":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v2, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v1, v2, :cond_1

    .line 368
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v2}, Lcom/poshmark/utils/sharing/PMShareContent;->getListing()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v2}, Lcom/poshmark/utils/sharing/PMShareContent;->getListing()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 369
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "share_listing_options_screen"

    const-string v3, "listing"

    const-string v4, "share_listing_failed"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 380
    :cond_0
    :goto_0
    return-void

    .line 370
    :cond_1
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v2, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v1, v2, :cond_2

    .line 371
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 372
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "referral_screen"

    const-string v3, "user"

    const-string v4, "referral_failed"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 373
    :cond_2
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v2, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v1, v2, :cond_3

    .line 374
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v2}, Lcom/poshmark/utils/sharing/PMShareContent;->getParty()Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v2}, Lcom/poshmark/utils/sharing/PMShareContent;->getParty()Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 375
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "share_party_options_screen"

    const-string v3, "party"

    const-string v4, "share_party_failed"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 376
    :cond_3
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v2, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-eq v1, v2, :cond_4

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v2, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND_JUSTIN:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v1, v2, :cond_0

    .line 377
    :cond_4
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v1}, Lcom/poshmark/utils/sharing/PMShareContent;->getBrand()Lcom/poshmark/data_model/models/Brand;

    move-result-object v1

    iget-object v0, v1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    .line 378
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "share_brand_options_screen"

    const-string v3, "brand"

    const-string v4, "share_brand_failed"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method public trackShareFragmentDisplayed()V
    .locals 4

    .prologue
    .line 120
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 121
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, ""

    .line 122
    .local v1, "screenTag":Ljava/lang/String;
    sget-object v2, Lcom/poshmark/utils/ShareManager$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 148
    :goto_0
    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 149
    const-string v2, "signup_segment"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserABSegment()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 150
    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getViewTrackingInfo(Ljava/util/Map;)V

    .line 152
    :cond_0
    return-void

    .line 124
    :pswitch_0
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenListingShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 125
    const-string v2, "oid"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getListing()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 128
    :pswitch_1
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenPartyShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 129
    const-string v2, "oid"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getParty()Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 132
    :pswitch_2
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenClosetShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    const-string v2, "oid"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getUser()Lcom/poshmark/user/UserInfoDetails;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 136
    :pswitch_3
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenShowroomShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 137
    const-string v2, "oid"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getShowroom()Lcom/poshmark/data_model/models/Showroom;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 140
    :pswitch_4
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenBrandShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    const-string v2, "oid"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager;->content:Lcom/poshmark/utils/sharing/PMShareContent;

    invoke-virtual {v3}, Lcom/poshmark/utils/sharing/PMShareContent;->getBrand()Lcom/poshmark/data_model/models/Brand;

    move-result-object v3

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 144
    :pswitch_5
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenReferralCodeShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    const-string v2, "oid"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 122
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

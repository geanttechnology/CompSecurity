.class Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;
.super Landroid/os/Handler;
.source "SourceFile"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 332
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v0, 0x0

    .line 335
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 336
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 380
    :goto_0
    return-void

    .line 338
    :pswitch_0
    sget v1, Lcom/mixerbox/mixerbox3b/MixerBox;->count:I

    if-gez v1, :cond_3

    .line 339
    # invokes: Lcom/mixerbox/mixerbox3b/MixerBox;->getAllArtistsFromSDCard()V
    invoke-static {}, Lcom/mixerbox/mixerbox3b/MixerBox;->access$200()V

    .line 343
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    sput-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->mp3ArtistId:Ljava/util/ArrayList;

    .line 344
    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    const-string v2, "artists.json"

    invoke-static {v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadJSONFromAsset(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 345
    sget-object v2, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    move v1, v0

    .line 346
    :goto_1
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->mp3Artist:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 347
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->mp3Artist:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {v2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 348
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->mp3ArtistId:Ljava/util/ArrayList;

    sget-object v3, Lcom/mixerbox/mixerbox3b/MixerBox;->mp3Artist:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 346
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 351
    :cond_1
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    if-nez v0, :cond_2

    .line 352
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    sput-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    .line 354
    :cond_2
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    const-string v1, "fav_artists"

    sget-object v2, Lcom/mixerbox/mixerbox3b/MixerBox;->mp3ArtistId:Ljava/util/ArrayList;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 356
    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    const-class v2, Lcom/mixerbox/mixerbox3b/Onboarding;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 357
    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 358
    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 359
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    goto :goto_0

    .line 361
    :cond_3
    sget-boolean v1, Lcom/mixerbox/mixerbox3b/MixerBox;->loginFlag:Z

    if-eqz v1, :cond_5

    .line 362
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    if-nez v0, :cond_4

    .line 363
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    sput-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    .line 364
    :cond_4
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/Session;->getAccessToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putFacebookToken(Landroid/content/Context;Ljava/lang/String;)V

    .line 365
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080074

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 366
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v1

    sget-object v2, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->laterLoginInit(Landroid/content/Context;Lcom/facebook/Session;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 368
    :cond_5
    sput-boolean v3, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->shouldOnCreate:Z

    .line 369
    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    if-nez v1, :cond_6

    .line 370
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    sput-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    .line 371
    :cond_6
    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    const-string v2, "isLogIn"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 372
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 373
    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->bundle:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 374
    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    const-class v2, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 375
    sget-object v1, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 376
    sget-object v0, Lcom/mixerbox/mixerbox3b/MixerBox;->ctx:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    goto/16 :goto_0

    .line 336
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

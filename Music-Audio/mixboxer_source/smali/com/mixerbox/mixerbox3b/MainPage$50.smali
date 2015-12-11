.class Lcom/mixerbox/mixerbox3b/MainPage$50;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 4355
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$50;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 4358
    const-string v0, "action:mb3_first_launch"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 4359
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$50;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getUserType(Landroid/content/Context;)I

    move-result v0

    .line 4360
    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 4361
    const-string v0, "status:v307_push_local"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 4362
    const-string v0, "http://bit.ly/androidv307_launch_local"

    new-instance v1, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v1}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v2, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 4376
    :cond_0
    :goto_0
    return-void

    .line 4364
    :cond_1
    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 4365
    const-string v0, "status:v307_push_server"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 4366
    const-string v0, "http://bit.ly/androidv307_launch_server"

    new-instance v1, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v1}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v2, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_0

    .line 4368
    :cond_2
    const/4 v1, 0x3

    if-ne v0, v1, :cond_3

    .line 4369
    const-string v0, "status:v307_push_local_and_server"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 4370
    const-string v0, "http://bit.ly/androidv307_launch_local_and_server"

    new-instance v1, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v1}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v2, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_0

    .line 4372
    :cond_3
    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 4373
    const-string v0, "status:v307_push_neither"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 4374
    const-string v0, "http://bit.ly/androidv307_launch_neither"

    new-instance v1, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v1}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v2, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_0
.end method

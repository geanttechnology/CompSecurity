.class final Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic val$b:Ljava/lang/String;

.field final synthetic val$id:Ljava/lang/String;

.field final synthetic val$s:Ljava/lang/String;

.field final synthetic val$v:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 276
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->val$id:Ljava/lang/String;

    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->val$b:Ljava/lang/String;

    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->val$v:Landroid/view/View;

    iput-object p5, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->val$s:Ljava/lang/String;

    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public final onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 291
    invoke-super {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 292
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->val$v:Landroid/view/View;

    check-cast v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->val$s:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 293
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080049

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 294
    return-void
.end method

.method public final onSuccess(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 279
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;->onSuccess(Ljava/lang/String;)V

    .line 280
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 281
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->ctx:Landroid/content/Context;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getDJs(Landroid/content/Context;)V

    .line 283
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800e9

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 284
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 285
    const-string v1, "dj_id"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->val$id:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 286
    const-string v1, "follow"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle$2;->val$b:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 287
    const-string v1, "action:follow"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 288
    return-void
.end method

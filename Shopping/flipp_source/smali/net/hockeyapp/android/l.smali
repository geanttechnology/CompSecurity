.class final Lnet/hockeyapp/android/l;
.super Landroid/os/Handler;
.source "SourceFile"


# instance fields
.field final synthetic a:Lnet/hockeyapp/android/FeedbackActivity;


# direct methods
.method constructor <init>(Lnet/hockeyapp/android/FeedbackActivity;)V
    .locals 0

    .prologue
    .line 218
    iput-object p1, p0, Lnet/hockeyapp/android/l;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 221
    .line 222
    iget-object v0, p0, Lnet/hockeyapp/android/l;->a:Lnet/hockeyapp/android/FeedbackActivity;

    new-instance v3, Lnet/hockeyapp/android/c/a;

    invoke-direct {v3}, Lnet/hockeyapp/android/c/a;-><init>()V

    invoke-static {v0, v3}, Lnet/hockeyapp/android/FeedbackActivity;->a(Lnet/hockeyapp/android/FeedbackActivity;Lnet/hockeyapp/android/c/a;)Lnet/hockeyapp/android/c/a;

    .line 224
    if-eqz p1, :cond_3

    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 225
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    .line 226
    const-string v3, "parse_feedback_response"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lnet/hockeyapp/android/c/d;

    .line 227
    if-eqz v0, :cond_3

    .line 228
    iget-object v3, v0, Lnet/hockeyapp/android/c/d;->a:Ljava/lang/String;

    const-string v4, "success"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 232
    iget-object v2, v0, Lnet/hockeyapp/android/c/d;->c:Ljava/lang/String;

    if-eqz v2, :cond_2

    .line 234
    sget-object v2, Lnet/hockeyapp/android/e/f;->a:Lnet/hockeyapp/android/e/e;

    iget-object v3, p0, Lnet/hockeyapp/android/l;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-static {v3}, Lnet/hockeyapp/android/FeedbackActivity;->c(Lnet/hockeyapp/android/FeedbackActivity;)Landroid/content/Context;

    move-result-object v3

    iget-object v4, v0, Lnet/hockeyapp/android/c/d;->c:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lnet/hockeyapp/android/e/e;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 236
    iget-object v2, p0, Lnet/hockeyapp/android/l;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-static {v2, v0}, Lnet/hockeyapp/android/FeedbackActivity;->a(Lnet/hockeyapp/android/FeedbackActivity;Lnet/hockeyapp/android/c/d;)V

    .line 237
    iget-object v0, p0, Lnet/hockeyapp/android/l;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-static {v0}, Lnet/hockeyapp/android/FeedbackActivity;->d(Lnet/hockeyapp/android/FeedbackActivity;)Z

    move v0, v1

    .line 247
    :goto_0
    if-nez v0, :cond_0

    .line 248
    iget-object v0, p0, Lnet/hockeyapp/android/l;->a:Lnet/hockeyapp/android/FeedbackActivity;

    new-instance v2, Lnet/hockeyapp/android/m;

    invoke-direct {v2, p0}, Lnet/hockeyapp/android/m;-><init>(Lnet/hockeyapp/android/l;)V

    invoke-virtual {v0, v2}, Lnet/hockeyapp/android/FeedbackActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 258
    :cond_0
    iget-object v0, p0, Lnet/hockeyapp/android/l;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-virtual {v0, v1}, Lnet/hockeyapp/android/FeedbackActivity;->b(Z)V

    .line 259
    return-void

    :cond_1
    move v0, v2

    .line 241
    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_0

    :cond_3
    move v0, v2

    goto :goto_0
.end method

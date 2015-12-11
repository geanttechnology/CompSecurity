.class final Lnet/hockeyapp/android/j;
.super Landroid/os/Handler;
.source "SourceFile"


# instance fields
.field final synthetic a:Lnet/hockeyapp/android/FeedbackActivity;


# direct methods
.method constructor <init>(Lnet/hockeyapp/android/FeedbackActivity;)V
    .locals 0

    .prologue
    .line 167
    iput-object p1, p0, Lnet/hockeyapp/android/j;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 7

    .prologue
    const/4 v1, 0x1

    .line 170
    const/4 v0, 0x0

    .line 171
    iget-object v2, p0, Lnet/hockeyapp/android/j;->a:Lnet/hockeyapp/android/FeedbackActivity;

    new-instance v3, Lnet/hockeyapp/android/c/a;

    invoke-direct {v3}, Lnet/hockeyapp/android/c/a;-><init>()V

    invoke-static {v2, v3}, Lnet/hockeyapp/android/FeedbackActivity;->a(Lnet/hockeyapp/android/FeedbackActivity;Lnet/hockeyapp/android/c/a;)Lnet/hockeyapp/android/c/a;

    .line 173
    if-eqz p1, :cond_6

    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    if-eqz v2, :cond_6

    .line 174
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    .line 175
    const-string v3, "feedback_response"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 176
    const-string v4, "feedback_status"

    invoke-virtual {v2, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 177
    const-string v5, "request_type"

    invoke-virtual {v2, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 178
    const-string v5, "send"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    if-eqz v3, :cond_0

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    const/16 v6, 0xc9

    if-eq v5, v6, :cond_2

    .line 180
    :cond_0
    iget-object v1, p0, Lnet/hockeyapp/android/j;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-static {v1}, Lnet/hockeyapp/android/FeedbackActivity;->a(Lnet/hockeyapp/android/FeedbackActivity;)Lnet/hockeyapp/android/c/a;

    move-result-object v1

    const-string v2, "Message couldn\'t be posted. Please check your input values and your connection, then try again."

    iput-object v2, v1, Lnet/hockeyapp/android/c/a;->a:Ljava/lang/String;

    .line 199
    :goto_0
    if-nez v0, :cond_1

    .line 200
    iget-object v0, p0, Lnet/hockeyapp/android/j;->a:Lnet/hockeyapp/android/FeedbackActivity;

    new-instance v1, Lnet/hockeyapp/android/k;

    invoke-direct {v1, p0}, Lnet/hockeyapp/android/k;-><init>(Lnet/hockeyapp/android/j;)V

    invoke-virtual {v0, v1}, Lnet/hockeyapp/android/FeedbackActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 210
    :cond_1
    return-void

    .line 182
    :cond_2
    const-string v5, "fetch"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    if-eqz v4, :cond_4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    const/16 v5, 0x194

    if-eq v2, v5, :cond_3

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    const/16 v4, 0x1a6

    if-ne v2, v4, :cond_4

    .line 184
    :cond_3
    iget-object v0, p0, Lnet/hockeyapp/android/j;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-static {v0}, Lnet/hockeyapp/android/FeedbackActivity;->b(Lnet/hockeyapp/android/FeedbackActivity;)V

    move v0, v1

    .line 185
    goto :goto_0

    .line 187
    :cond_4
    if-eqz v3, :cond_5

    .line 188
    iget-object v0, p0, Lnet/hockeyapp/android/j;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-static {v0, v3}, Lnet/hockeyapp/android/FeedbackActivity;->a(Lnet/hockeyapp/android/FeedbackActivity;Ljava/lang/String;)V

    move v0, v1

    .line 189
    goto :goto_0

    .line 192
    :cond_5
    iget-object v1, p0, Lnet/hockeyapp/android/j;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-static {v1}, Lnet/hockeyapp/android/FeedbackActivity;->a(Lnet/hockeyapp/android/FeedbackActivity;)Lnet/hockeyapp/android/c/a;

    move-result-object v1

    const-string v2, "No response from server. Please check your connection, then try again."

    iput-object v2, v1, Lnet/hockeyapp/android/c/a;->a:Ljava/lang/String;

    goto :goto_0

    .line 196
    :cond_6
    iget-object v1, p0, Lnet/hockeyapp/android/j;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-static {v1}, Lnet/hockeyapp/android/FeedbackActivity;->a(Lnet/hockeyapp/android/FeedbackActivity;)Lnet/hockeyapp/android/c/a;

    move-result-object v1

    const-string v2, "Message couldn\'t be posted. Please check your input values and your connection, then try again."

    iput-object v2, v1, Lnet/hockeyapp/android/c/a;->a:Ljava/lang/String;

    goto :goto_0
.end method

.class Lco/vine/android/ConversationFragment$2;
.super Ljava/lang/Object;
.source "ConversationFragment.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/ConversationFragment;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationFragment;


# direct methods
.method constructor <init>(Lco/vine/android/ConversationFragment;)V
    .locals 0

    .prologue
    .line 196
    iput-object p1, p0, Lco/vine/android/ConversationFragment$2;->this$0:Lco/vine/android/ConversationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 2
    .param p1, "name"    # Landroid/content/ComponentName;
    .param p2, "service"    # Landroid/os/IBinder;

    .prologue
    .line 199
    const-string v0, "ConversationFrag"

    const-string v1, "Bound to VineUploadService"

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    iget-object v0, p0, Lco/vine/android/ConversationFragment$2;->this$0:Lco/vine/android/ConversationFragment;

    new-instance v1, Landroid/os/Messenger;

    invoke-direct {v1, p2}, Landroid/os/Messenger;-><init>(Landroid/os/IBinder;)V

    # setter for: Lco/vine/android/ConversationFragment;->mUploadServiceMessenger:Landroid/os/Messenger;
    invoke-static {v0, v1}, Lco/vine/android/ConversationFragment;->access$102(Lco/vine/android/ConversationFragment;Landroid/os/Messenger;)Landroid/os/Messenger;

    .line 201
    iget-object v0, p0, Lco/vine/android/ConversationFragment$2;->this$0:Lco/vine/android/ConversationFragment;

    const/4 v1, 0x1

    # setter for: Lco/vine/android/ConversationFragment;->mBound:Z
    invoke-static {v0, v1}, Lco/vine/android/ConversationFragment;->access$202(Lco/vine/android/ConversationFragment;Z)Z

    .line 204
    iget-object v0, p0, Lco/vine/android/ConversationFragment$2;->this$0:Lco/vine/android/ConversationFragment;

    iget-object v1, p0, Lco/vine/android/ConversationFragment$2;->this$0:Lco/vine/android/ConversationFragment;

    # getter for: Lco/vine/android/ConversationFragment;->mIncomingHandler:Landroid/os/Handler;
    invoke-static {v1}, Lco/vine/android/ConversationFragment;->access$300(Lco/vine/android/ConversationFragment;)Landroid/os/Handler;

    move-result-object v1

    # invokes: Lco/vine/android/ConversationFragment;->subscribe(Landroid/os/Handler;)V
    invoke-static {v0, v1}, Lco/vine/android/ConversationFragment;->access$400(Lco/vine/android/ConversationFragment;Landroid/os/Handler;)V

    .line 205
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2
    .param p1, "name"    # Landroid/content/ComponentName;

    .prologue
    .line 209
    const-string v0, "ConversationFrag"

    const-string v1, "Connection to VineUploadService lost unexpectedly!"

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    iget-object v0, p0, Lco/vine/android/ConversationFragment$2;->this$0:Lco/vine/android/ConversationFragment;

    const/4 v1, 0x0

    # setter for: Lco/vine/android/ConversationFragment;->mUploadServiceMessenger:Landroid/os/Messenger;
    invoke-static {v0, v1}, Lco/vine/android/ConversationFragment;->access$102(Lco/vine/android/ConversationFragment;Landroid/os/Messenger;)Landroid/os/Messenger;

    .line 211
    iget-object v0, p0, Lco/vine/android/ConversationFragment$2;->this$0:Lco/vine/android/ConversationFragment;

    const/4 v1, 0x0

    # setter for: Lco/vine/android/ConversationFragment;->mBound:Z
    invoke-static {v0, v1}, Lco/vine/android/ConversationFragment;->access$202(Lco/vine/android/ConversationFragment;Z)Z

    .line 212
    return-void
.end method

.class Lcom/aio/downloader/activity/MySettingsActivity$7;
.super Ljava/lang/Object;
.source "MySettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MySettingsActivity;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MySettingsActivity;

.field private final synthetic val$helpusShareDialog:Lcom/aio/downloader/dialog/HelpusShareDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MySettingsActivity;Lcom/aio/downloader/dialog/HelpusShareDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity$7;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/MySettingsActivity$7;->val$helpusShareDialog:Lcom/aio/downloader/dialog/HelpusShareDialog;

    .line 328
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 332
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$7;->val$helpusShareDialog:Lcom/aio/downloader/dialog/HelpusShareDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/HelpusShareDialog;->dismiss()V

    .line 334
    return-void
.end method

.class Lcom/aio/downloader/activity/MySettingsActivity$8;
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
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity$8;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/MySettingsActivity$8;->val$helpusShareDialog:Lcom/aio/downloader/dialog/HelpusShareDialog;

    .line 338
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 342
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 344
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "android.intent.extra.TEXT"

    const-string v2, "http://tinyurl.com/allinone-downloader"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 345
    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 346
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 347
    iget-object v1, p0, Lcom/aio/downloader/activity/MySettingsActivity$8;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    const-string v2, "Share a free tool to download music & app..."

    invoke-static {v0, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/MySettingsActivity;->startActivity(Landroid/content/Intent;)V

    .line 348
    iget-object v1, p0, Lcom/aio/downloader/activity/MySettingsActivity$8;->val$helpusShareDialog:Lcom/aio/downloader/dialog/HelpusShareDialog;

    invoke-virtual {v1}, Lcom/aio/downloader/dialog/HelpusShareDialog;->dismiss()V

    .line 350
    return-void
.end method

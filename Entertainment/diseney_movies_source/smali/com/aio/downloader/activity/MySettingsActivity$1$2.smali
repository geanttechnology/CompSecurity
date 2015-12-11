.class Lcom/aio/downloader/activity/MySettingsActivity$1$2;
.super Ljava/lang/Object;
.source "MySettingsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MySettingsActivity$1;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MySettingsActivity$1;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/NoupdareversionDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MySettingsActivity$1;Lcom/aio/downloader/dialog/NoupdareversionDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity$1$2;->this$1:Lcom/aio/downloader/activity/MySettingsActivity$1;

    iput-object p2, p0, Lcom/aio/downloader/activity/MySettingsActivity$1$2;->val$dialog:Lcom/aio/downloader/dialog/NoupdareversionDialog;

    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 106
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$1$2;->val$dialog:Lcom/aio/downloader/dialog/NoupdareversionDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/NoupdareversionDialog;->dismiss()V

    .line 108
    return-void
.end method

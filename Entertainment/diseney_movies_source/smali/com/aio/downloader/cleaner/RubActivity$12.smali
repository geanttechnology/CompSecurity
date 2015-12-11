.class Lcom/aio/downloader/cleaner/RubActivity$12;
.super Ljava/lang/Object;
.source "RubActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity;->downwifi()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/RubActivity;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$12;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iput-object p2, p0, Lcom/aio/downloader/cleaner/RubActivity$12;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    .line 1254
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 1258
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$12;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    new-instance v1, Landroid/content/Intent;

    .line 1259
    const-string v2, "android.settings.WIRELESS_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1258
    invoke-virtual {v0, v1}, Lcom/aio/downloader/cleaner/RubActivity;->startActivity(Landroid/content/Intent;)V

    .line 1260
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$12;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->dismiss()V

    .line 1262
    return-void
.end method

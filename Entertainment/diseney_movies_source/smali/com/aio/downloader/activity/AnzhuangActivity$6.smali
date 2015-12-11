.class Lcom/aio/downloader/activity/AnzhuangActivity$6;
.super Ljava/lang/Object;
.source "AnzhuangActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AnzhuangActivity;->downwifi()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

.field private final synthetic val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AnzhuangActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AnzhuangActivity$6;->this$0:Lcom/aio/downloader/activity/AnzhuangActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/AnzhuangActivity$6;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    .line 469
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 473
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity$6;->val$dialog:Lcom/aio/downloader/dialog/LianwangDialog;

    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->dismiss()V

    .line 475
    return-void
.end method

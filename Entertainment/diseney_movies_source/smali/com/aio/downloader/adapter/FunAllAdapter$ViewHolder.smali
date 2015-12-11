.class Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "FunAllAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/FunAllAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field bt_gif:Landroid/widget/Button;

.field bt_pics:Landroid/widget/Button;

.field bt_share:Landroid/widget/Button;

.field bt_video:Landroid/widget/Button;

.field fun_fd_iv:Landroid/widget/ImageView;

.field fun_fd_tv_title:Landroid/widget/TextView;

.field iv_fun:Landroid/widget/ImageView;

.field iv_like_new:Landroid/widget/ImageView;

.field lin_fd:Landroid/widget/LinearLayout;

.field lin_fd_dia:Landroid/widget/LinearLayout;

.field ll_fun_like:Landroid/widget/LinearLayout;

.field ll_fun_share:Landroid/widget/LinearLayout;

.field rl_like:Landroid/widget/RelativeLayout;

.field final synthetic this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

.field tv_fun:Landroid/widget/TextView;

.field tv_funadult_download:Landroid/widget/TextView;

.field tv_funadult_like:Landroid/widget/TextView;

.field tv_funadult_share:Landroid/widget/TextView;

.field tv_funadult_time:Landroid/widget/TextView;

.field v_fun_top:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/FunAllAdapter;)V
    .locals 0

    .prologue
    .line 592
    iput-object p1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$ViewHolder;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

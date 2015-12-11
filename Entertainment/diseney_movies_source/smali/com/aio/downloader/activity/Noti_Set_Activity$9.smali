.class Lcom/aio/downloader/activity/Noti_Set_Activity$9;
.super Ljava/lang/Object;
.source "Noti_Set_Activity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/Noti_Set_Activity;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/Noti_Set_Activity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/Noti_Set_Activity$9;->this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;

    .line 253
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 258
    iget-object v0, p0, Lcom/aio/downloader/activity/Noti_Set_Activity$9;->this$0:Lcom/aio/downloader/activity/Noti_Set_Activity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/Noti_Set_Activity;->finish()V

    .line 259
    return-void
.end method

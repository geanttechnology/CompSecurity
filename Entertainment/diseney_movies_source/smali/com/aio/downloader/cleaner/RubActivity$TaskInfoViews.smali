.class Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;
.super Ljava/lang/Object;
.source "RubActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/RubActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TaskInfoViews"
.end annotation


# instance fields
.field cb_process_state:Landroid/widget/CheckBox;

.field iv_process_icon:Landroid/widget/ImageView;

.field final synthetic this$0:Lcom/aio/downloader/cleaner/RubActivity;

.field tv_process_memory:Landroid/widget/TextView;

.field tv_process_name:Landroid/widget/TextView;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 986
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;)V
    .locals 0

    .prologue
    .line 986
    invoke-direct {p0, p1}, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;-><init>(Lcom/aio/downloader/cleaner/RubActivity;)V

    return-void
.end method

.class Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "LDialogListBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ViewHolder"
.end annotation


# instance fields
.field mIconImageView:Landroid/widget/ImageView;

.field mTextView:Landroid/widget/TextView;

.field final synthetic this$1:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;


# direct methods
.method private constructor <init>(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;)V
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;->this$1:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;)V
    .locals 0

    .prologue
    .line 142
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;-><init>(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;)V

    return-void
.end method

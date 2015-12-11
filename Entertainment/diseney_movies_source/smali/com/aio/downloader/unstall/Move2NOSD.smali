.class public Lcom/aio/downloader/unstall/Move2NOSD;
.super Landroid/app/Activity;
.source "Move2NOSD.java"


# instance fields
.field private firstsd:J

.field private header_left_move2nosd:Lcom/aio/downloader/views/LImageButton;

.field private memoryManager:Lcom/aio/downloader/utils/MemoryManager;

.field private sencondsd:J

.field private tv_nosd:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const-wide/16 v0, 0x0

    .line 14
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 16
    iput-wide v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->sencondsd:J

    .line 17
    iput-wide v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->firstsd:J

    .line 14
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const-wide/16 v2, 0x0

    .line 24
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 25
    const v0, 0x7f03007a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/unstall/Move2NOSD;->setContentView(I)V

    .line 27
    new-instance v0, Lcom/aio/downloader/utils/MemoryManager;

    invoke-virtual {p0}, Lcom/aio/downloader/unstall/Move2NOSD;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/aio/downloader/utils/MemoryManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->memoryManager:Lcom/aio/downloader/utils/MemoryManager;

    .line 28
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->memoryManager:Lcom/aio/downloader/utils/MemoryManager;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/MemoryManager;->getSecondSDTotalSize()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->sencondsd:J

    .line 29
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->memoryManager:Lcom/aio/downloader/utils/MemoryManager;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/MemoryManager;->getSDTotalSize()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->firstsd:J

    .line 30
    const v0, 0x7f0702e6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/unstall/Move2NOSD;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->header_left_move2nosd:Lcom/aio/downloader/views/LImageButton;

    .line 31
    const v0, 0x7f0702e7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/unstall/Move2NOSD;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->tv_nosd:Landroid/widget/TextView;

    .line 32
    iget-wide v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->sencondsd:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-wide v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->firstsd:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->tv_nosd:Landroid/widget/TextView;

    const-string v1, "Your device storage and internal SD card are the same, so moving is unnecessary."

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 37
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->header_left_move2nosd:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/unstall/Move2NOSD$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/unstall/Move2NOSD$1;-><init>(Lcom/aio/downloader/unstall/Move2NOSD;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 45
    return-void

    .line 35
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2NOSD;->tv_nosd:Landroid/widget/TextView;

    const-string v1, "Unfortunately, your device doesn\'t support moving apps."

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.class public Lcom/aio/downloader/views/LDialogListBuilder;
.super Lcom/aio/downloader/views/LAlertDialog$Builder;
.source "LDialogListBuilder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;
    }
.end annotation


# instance fields
.field private mAdapter:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

.field private mContext:Landroid/content/Context;

.field private mController:Lcom/aio/downloader/views/LDialogController;

.field private mIsChooseMode:Z

.field private mListView:Landroid/widget/ListView;

.field private mListener:Landroid/content/DialogInterface$OnClickListener;

.field private mSelectedIndex:I


# direct methods
.method public constructor <init>(Landroid/content/Context;IZ)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "selectedIndex"    # I
    .param p3, "isChooseMode"    # Z

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/aio/downloader/views/LAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 21
    const/4 v1, -0x1

    iput v1, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mSelectedIndex:I

    .line 28
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mContext:Landroid/content/Context;

    .line 29
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mContext:Landroid/content/Context;

    const v2, 0x7f030072

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 30
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0702c5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mListView:Landroid/widget/ListView;

    .line 31
    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/LDialogListBuilder;->setView(Landroid/view/View;)Lcom/aio/downloader/views/LAlertDialog$Builder;

    .line 32
    iput p2, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mSelectedIndex:I

    .line 33
    iput-boolean p3, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mIsChooseMode:Z

    .line 34
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/LDialogListBuilder;)Landroid/content/DialogInterface$OnClickListener;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mListener:Landroid/content/DialogInterface$OnClickListener;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/views/LDialogListBuilder;)Lcom/aio/downloader/views/LDialogController;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mController:Lcom/aio/downloader/views/LDialogController;

    return-object v0
.end method


# virtual methods
.method public create()Lcom/aio/downloader/views/LAlertDialog;
    .locals 2

    .prologue
    .line 58
    invoke-super {p0}, Lcom/aio/downloader/views/LAlertDialog$Builder;->create()Lcom/aio/downloader/views/LAlertDialog;

    move-result-object v0

    .line 59
    .local v0, "dialog":Lcom/aio/downloader/views/LAlertDialog;
    invoke-virtual {v0}, Lcom/aio/downloader/views/LAlertDialog;->getController()Lcom/aio/downloader/views/LDialogController;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mController:Lcom/aio/downloader/views/LDialogController;

    .line 60
    return-object v0
.end method

.method public setItems([Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 6
    .param p1, "items"    # [Ljava/lang/String;
    .param p2, "listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 37
    iput-object p2, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mListener:Landroid/content/DialogInterface$OnClickListener;

    .line 38
    new-instance v0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    iget-object v2, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mContext:Landroid/content/Context;

    iget v4, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mSelectedIndex:I

    .line 39
    iget-boolean v5, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mIsChooseMode:Z

    move-object v1, p0

    move-object v3, p1

    invoke-direct/range {v0 .. v5}, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;-><init>(Lcom/aio/downloader/views/LDialogListBuilder;Landroid/content/Context;[Ljava/lang/String;IZ)V

    .line 38
    iput-object v0, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mAdapter:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    .line 40
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mAdapter:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 41
    return-object p0
.end method

.method public setSelectedIndex(I)V
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 45
    iput p1, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mSelectedIndex:I

    .line 46
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mAdapter:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogListBuilder;->mAdapter:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    invoke-virtual {v0, p1}, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->setSelectedIndex(I)V

    .line 50
    :cond_0
    return-void
.end method

.method public show()Lcom/aio/downloader/views/LAlertDialog;
    .locals 1

    .prologue
    .line 69
    invoke-virtual {p0}, Lcom/aio/downloader/views/LDialogListBuilder;->create()Lcom/aio/downloader/views/LAlertDialog;

    move-result-object v0

    .line 70
    .local v0, "dialog":Lcom/aio/downloader/views/LAlertDialog;
    invoke-virtual {v0}, Lcom/aio/downloader/views/LAlertDialog;->show()V

    .line 71
    return-object v0
.end method

.class public Lcom/amazon/mShop/AmazonAlertDialog;
.super Landroid/app/AlertDialog;
.source "AmazonAlertDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/AmazonAlertDialog$1;,
        Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    }
.end annotation


# instance fields
.field public final BUTTON_TEXT_LINE_NUM:I

.field private dismissedOnTrackBall:Z

.field private mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Landroid/app/AlertDialog;-><init>(Landroid/content/Context;)V

    .line 54
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/AmazonAlertDialog;->dismissedOnTrackBall:Z

    .line 40
    const/4 v0, 0x2

    iput v0, p0, Lcom/amazon/mShop/AmazonAlertDialog;->BUTTON_TEXT_LINE_NUM:I

    .line 41
    iput-object p1, p0, Lcom/amazon/mShop/AmazonAlertDialog;->mContext:Landroid/content/Context;

    .line 42
    return-void
.end method

.method public static customizeAlertDialog(Landroid/content/Context;Lcom/amazon/mShop/AmazonAlertDialog;Ljava/lang/String;Landroid/widget/ListAdapter;Landroid/widget/AdapterView$OnItemClickListener;I)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dialog"    # Lcom/amazon/mShop/AmazonAlertDialog;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "adapter"    # Landroid/widget/ListAdapter;
    .param p4, "listener"    # Landroid/widget/AdapterView$OnItemClickListener;
    .param p5, "checkedItem"    # I

    .prologue
    const/4 v2, 0x0

    .line 292
    if-eqz p3, :cond_1

    .line 293
    new-instance v1, Landroid/widget/ListView;

    invoke-direct {v1, p0}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 294
    .local v1, "listview":Landroid/widget/ListView;
    invoke-virtual {v1, p4}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 295
    sget v0, Lcom/amazon/mShop/android/lib/R$color;->white:I

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setBackgroundResource(I)V

    .line 298
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v3, Lcom/amazon/mShop/android/lib/R$color;->white:I

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setCacheColorHint(I)V

    .line 299
    sget v0, Lcom/amazon/mShop/android/lib/R$color;->common_selector:I

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setSelector(I)V

    .line 300
    invoke-virtual {v1, p3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 301
    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setScrollbarFadingEnabled(Z)V

    .line 302
    if-ltz p5, :cond_0

    .line 303
    invoke-virtual {v1, p5}, Landroid/widget/ListView;->setSelection(I)V

    :cond_0
    move-object v0, p1

    move v3, v2

    move v4, v2

    move v5, v2

    .line 305
    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/AmazonAlertDialog;->setView(Landroid/view/View;IIII)V

    .line 308
    .end local v1    # "listview":Landroid/widget/ListView;
    :cond_1
    invoke-virtual {p1, p2}, Lcom/amazon/mShop/AmazonAlertDialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 309
    return-void
.end method


# virtual methods
.method protected adjustWidgets()V
    .locals 2

    .prologue
    .line 66
    const/4 v1, -0x1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonAlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v0

    .line 67
    .local v0, "btn":Landroid/widget/Button;
    if-eqz v0, :cond_0

    .line 68
    iget v1, p0, Lcom/amazon/mShop/AmazonAlertDialog;->BUTTON_TEXT_LINE_NUM:I

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setLines(I)V

    .line 70
    :cond_0
    const/4 v1, -0x3

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonAlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v0

    .line 71
    if-eqz v0, :cond_1

    .line 72
    iget v1, p0, Lcom/amazon/mShop/AmazonAlertDialog;->BUTTON_TEXT_LINE_NUM:I

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setLines(I)V

    .line 74
    :cond_1
    const/4 v1, -0x2

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/AmazonAlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v0

    .line 75
    if-eqz v0, :cond_2

    .line 76
    iget v1, p0, Lcom/amazon/mShop/AmazonAlertDialog;->BUTTON_TEXT_LINE_NUM:I

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setLines(I)V

    .line 78
    :cond_2
    return-void
.end method

.method public dismiss()V
    .locals 3

    .prologue
    .line 105
    :try_start_0
    invoke-super {p0}, Landroid/app/AlertDialog;->dismiss()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 111
    :goto_0
    return-void

    .line 107
    :catch_0
    move-exception v0

    .line 109
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "AmazonAlertDialog"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 58
    invoke-super {p0, p1}, Landroid/app/AlertDialog;->onCreate(Landroid/os/Bundle;)V

    .line 59
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonAlertDialog;->adjustWidgets()V

    .line 60
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 125
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 126
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog;->mContext:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->onSearchRequested()Z

    move-result v0

    return v0
.end method

.method public onTrackballEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 115
    iget-boolean v0, p0, Lcom/amazon/mShop/AmazonAlertDialog;->dismissedOnTrackBall:Z

    if-eqz v0, :cond_0

    .line 116
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_0

    .line 117
    invoke-super {p0}, Landroid/app/AlertDialog;->cancel()V

    .line 120
    :cond_0
    invoke-super {p0, p1}, Landroid/app/AlertDialog;->onTrackballEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public setDismissedOnTrackBall(Z)V
    .locals 0
    .param p1, "isDismissedOnTrackBall"    # Z

    .prologue
    .line 84
    iput-boolean p1, p0, Lcom/amazon/mShop/AmazonAlertDialog;->dismissedOnTrackBall:Z

    .line 85
    return-void
.end method

.method public show()V
    .locals 3

    .prologue
    .line 95
    :try_start_0
    invoke-super {p0}, Landroid/app/AlertDialog;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    :goto_0
    return-void

    .line 96
    :catch_0
    move-exception v0

    .line 97
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "AmazonAlertDialog"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

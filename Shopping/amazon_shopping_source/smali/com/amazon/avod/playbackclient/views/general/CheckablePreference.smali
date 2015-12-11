.class public Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;
.super Landroid/widget/LinearLayout;
.source "CheckablePreference.java"

# interfaces
.implements Landroid/widget/Checkable;


# instance fields
.field private mCheckableView:Landroid/widget/Checkable;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;)Landroid/widget/Checkable;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;->mCheckableView:Landroid/widget/Checkable;

    return-object v0
.end method


# virtual methods
.method public isChecked()Z
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;->mCheckableView:Landroid/widget/Checkable;

    invoke-interface {v0}, Landroid/widget/Checkable;->isChecked()Z

    move-result v0

    return v0
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 36
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 38
    const v0, 0x1020001

    invoke-virtual {p0, v0}, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Checkable;

    invoke-static {v0}, Lcom/google/common/base/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Checkable;

    iput-object v0, p0, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;->mCheckableView:Landroid/widget/Checkable;

    .line 41
    new-instance v0, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference$1;

    invoke-direct {v0, p0}, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference$1;-><init>(Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;)V

    invoke-virtual {p0, v0}, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 48
    return-void
.end method

.method public setChecked(Z)V
    .locals 1
    .param p1, "checked"    # Z

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;->mCheckableView:Landroid/widget/Checkable;

    invoke-interface {v0, p1}, Landroid/widget/Checkable;->setChecked(Z)V

    .line 58
    return-void
.end method

.method public toggle()V
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/avod/playbackclient/views/general/CheckablePreference;->mCheckableView:Landroid/widget/Checkable;

    invoke-interface {v0}, Landroid/widget/Checkable;->toggle()V

    .line 63
    return-void
.end method

.class public Lcom/bestbuy/android/activities/bbyscan/NoScanResultFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/view/View;

.field private b:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 18
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "Use the scanner in a well-lit area."

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "Try holding your device at different angles."

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/NoScanResultFragment;->b:[Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 43
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 44
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 25
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/activities/bbyscan/NoScanResultFragment;->d:Landroid/app/Activity;

    .line 27
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 30
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 31
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3

    .prologue
    .line 35
    const v0, 0x7f030081

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/NoScanResultFragment;->a:Landroid/view/View;

    .line 36
    const-string v0, ""

    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/NoScanResultFragment;->b:[Ljava/lang/String;

    invoke-static {v0, v1}, Lbs;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/NoScanResultFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0132

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/NoScanResultFragment;->a:Landroid/view/View;

    return-object v0
.end method

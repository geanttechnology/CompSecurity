.class public Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/view/View;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 17
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->b:Ljava/lang/String;

    .line 18
    const-string v0, "&#8226 \t Try using fewer or less-specific keywords.<br/> &#8226 \t Double-check your spelling.<br/> &#8226 \t Make sure to add spaces between words."

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->c:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 46
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 47
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 25
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->d:Landroid/app/Activity;

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
    const v0, 0x7f030082

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->a:Landroid/view/View;

    .line 36
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 37
    if-eqz v0, :cond_0

    .line 38
    const-string v1, "Query"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->b:Ljava/lang/String;

    .line 39
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0131

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "We couldn\'t find any matches for: \n \""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0132

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->c:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/NoSearchResultFragment;->a:Landroid/view/View;

    return-object v0
.end method

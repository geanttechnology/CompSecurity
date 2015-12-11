.class public abstract Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;
.super Landroid/text/style/ClickableSpan;
.source "SearchLinkSpan.java"


# instance fields
.field private final res:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>(Landroid/content/res/Resources;)V
    .locals 0
    .param p1, "res"    # Landroid/content/res/Resources;

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;->res:Landroid/content/res/Resources;

    .line 19
    return-void
.end method


# virtual methods
.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 2
    .param p1, "ds"    # Landroid/text/TextPaint;

    .prologue
    .line 23
    invoke-super {p0, p1}, Landroid/text/style/ClickableSpan;->updateDrawState(Landroid/text/TextPaint;)V

    .line 24
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 25
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;->res:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/retailsearch/R$color;->aui_link:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 26
    return-void
.end method

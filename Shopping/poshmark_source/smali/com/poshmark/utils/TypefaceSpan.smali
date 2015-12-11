.class public Lcom/poshmark/utils/TypefaceSpan;
.super Landroid/text/style/MetricAffectingSpan;
.source "TypefaceSpan.java"


# static fields
.field private static sTypefaceCache:Landroid/support/v4/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LruCache",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Typeface;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mTypeface:Landroid/graphics/Typeface;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 12
    new-instance v0, Landroid/support/v4/util/LruCache;

    const/16 v1, 0xc

    invoke-direct {v0, v1}, Landroid/support/v4/util/LruCache;-><init>(I)V

    sput-object v0, Lcom/poshmark/utils/TypefaceSpan;->sTypefaceCache:Landroid/support/v4/util/LruCache;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "typefaceName"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/text/style/MetricAffectingSpan;-><init>()V

    .line 20
    sget-object v0, Lcom/poshmark/utils/TypefaceSpan;->sTypefaceCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v0, p2}, Landroid/support/v4/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Typeface;

    iput-object v0, p0, Lcom/poshmark/utils/TypefaceSpan;->mTypeface:Landroid/graphics/Typeface;

    .line 22
    iget-object v0, p0, Lcom/poshmark/utils/TypefaceSpan;->mTypeface:Landroid/graphics/Typeface;

    if-nez v0, :cond_0

    .line 23
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    invoke-static {v0, p2}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/TypefaceSpan;->mTypeface:Landroid/graphics/Typeface;

    .line 26
    sget-object v0, Lcom/poshmark/utils/TypefaceSpan;->sTypefaceCache:Landroid/support/v4/util/LruCache;

    iget-object v1, p0, Lcom/poshmark/utils/TypefaceSpan;->mTypeface:Landroid/graphics/Typeface;

    invoke-virtual {v0, p2, v1}, Landroid/support/v4/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 28
    :cond_0
    return-void
.end method


# virtual methods
.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 4
    .param p1, "tp"    # Landroid/text/TextPaint;

    .prologue
    .line 38
    const/high16 v0, 0x40a00000    # 5.0f

    const/4 v1, 0x0

    const/high16 v2, 0x3f800000    # 1.0f

    const/high16 v3, -0x1000000

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/text/TextPaint;->setShadowLayer(FFFI)V

    .line 39
    iget-object v0, p0, Lcom/poshmark/utils/TypefaceSpan;->mTypeface:Landroid/graphics/Typeface;

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 40
    return-void
.end method

.method public updateMeasureState(Landroid/text/TextPaint;)V
    .locals 4
    .param p1, "p"    # Landroid/text/TextPaint;

    .prologue
    .line 32
    const/high16 v0, 0x40a00000    # 5.0f

    const/4 v1, 0x0

    const/high16 v2, 0x3f800000    # 1.0f

    const/high16 v3, -0x1000000

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/text/TextPaint;->setShadowLayer(FFFI)V

    .line 33
    iget-object v0, p0, Lcom/poshmark/utils/TypefaceSpan;->mTypeface:Landroid/graphics/Typeface;

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 34
    return-void
.end method

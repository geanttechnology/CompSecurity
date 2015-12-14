.class public Lcom/livemixtapes/App$ScalableStateListDrawable;
.super Landroid/graphics/drawable/StateListDrawable;
.source "App.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/App;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ScalableStateListDrawable"
.end annotation


# instance fields
.field public bottomLeftRadius:F

.field public bottomRightRadius:F

.field public radius:F

.field public topLeftRadius:F

.field public topRightRadius:F


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 211
    invoke-direct {p0}, Landroid/graphics/drawable/StateListDrawable;-><init>()V

    return-void
.end method

.method private scaleGradient(Landroid/graphics/drawable/GradientDrawable;)V
    .locals 0
    .param p1, "gradient"    # Landroid/graphics/drawable/GradientDrawable;

    .prologue
    .line 233
    return-void
.end method


# virtual methods
.method protected onStateChange([I)Z
    .locals 2
    .param p1, "stateSet"    # [I

    .prologue
    .line 216
    invoke-super {p0, p1}, Landroid/graphics/drawable/StateListDrawable;->onStateChange([I)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 218
    .local v0, "changed":Ljava/lang/Boolean;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/livemixtapes/App$ScalableStateListDrawable;->scale()V

    .line 220
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    return v1
.end method

.method public scale()V
    .locals 2

    .prologue
    .line 224
    invoke-virtual {p0}, Lcom/livemixtapes/App$ScalableStateListDrawable;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 226
    .local v0, "current":Landroid/graphics/drawable/Drawable;
    instance-of v1, v0, Landroid/graphics/drawable/GradientDrawable;

    if-eqz v1, :cond_0

    .line 227
    check-cast v0, Landroid/graphics/drawable/GradientDrawable;

    .end local v0    # "current":Landroid/graphics/drawable/Drawable;
    invoke-direct {p0, v0}, Lcom/livemixtapes/App$ScalableStateListDrawable;->scaleGradient(Landroid/graphics/drawable/GradientDrawable;)V

    .line 229
    :cond_0
    return-void
.end method

.class public Lco/vine/android/widget/ImagePreference;
.super Landroid/preference/Preference;
.source "ImagePreference.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/ImagePreference$OnImagePreferenceBoundListener;
    }
.end annotation


# instance fields
.field private mBorder:Landroid/widget/ImageView;

.field private mContext:Landroid/content/Context;

.field private mImage:Landroid/widget/ImageView;

.field private mListener:Lco/vine/android/widget/ImagePreference$OnImagePreferenceBoundListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 33
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/widget/ImagePreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 34
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 37
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lco/vine/android/widget/ImagePreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 38
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 41
    invoke-direct {p0, p1, p2, p3}, Landroid/preference/Preference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 42
    const v0, 0x7f03004a

    invoke-virtual {p0, v0}, Lco/vine/android/widget/ImagePreference;->setLayoutResource(I)V

    .line 43
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/widget/ImagePreference;->setSelectable(Z)V

    .line 44
    iput-object p1, p0, Lco/vine/android/widget/ImagePreference;->mContext:Landroid/content/Context;

    .line 45
    return-void
.end method


# virtual methods
.method protected onBindView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 88
    invoke-super {p0, p1}, Landroid/preference/Preference;->onBindView(Landroid/view/View;)V

    .line 89
    const v0, 0x7f0a0063

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/widget/ImagePreference;->mImage:Landroid/widget/ImageView;

    .line 90
    const v0, 0x7f0a022a

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lco/vine/android/widget/ImagePreference;->mBorder:Landroid/widget/ImageView;

    .line 91
    iget-object v0, p0, Lco/vine/android/widget/ImagePreference;->mListener:Lco/vine/android/widget/ImagePreference$OnImagePreferenceBoundListener;

    invoke-interface {v0, p0}, Lco/vine/android/widget/ImagePreference$OnImagePreferenceBoundListener;->onImagePeferenceBound(Lco/vine/android/widget/ImagePreference;)V

    .line 92
    return-void
.end method

.method protected onCreateView(Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 49
    invoke-super {p0, p1}, Landroid/preference/Preference;->onCreateView(Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 50
    .local v1, "v":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 52
    .local v0, "params":Landroid/view/ViewGroup$LayoutParams;
    iget-object v2, p0, Lco/vine/android/widget/ImagePreference;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    float-to-int v2, v2

    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 53
    invoke-virtual {v1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 55
    return-object v1
.end method

.method public setBitmap(Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 59
    iget-object v0, p0, Lco/vine/android/widget/ImagePreference;->mImage:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lco/vine/android/widget/ImagePreference;->mImage:Landroid/widget/ImageView;

    new-instance v1, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v2, p0, Lco/vine/android/widget/ImagePreference;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 62
    :cond_0
    return-void
.end method

.method public setBorderDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 71
    iget-object v0, p0, Lco/vine/android/widget/ImagePreference;->mBorder:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 72
    iget-object v0, p0, Lco/vine/android/widget/ImagePreference;->mBorder:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 74
    :cond_0
    return-void
.end method

.method public setDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 65
    iget-object v0, p0, Lco/vine/android/widget/ImagePreference;->mImage:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lco/vine/android/widget/ImagePreference;->mImage:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 68
    :cond_0
    return-void
.end method

.method public setImageClickListener(Landroid/view/View$OnClickListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 81
    iget-object v0, p0, Lco/vine/android/widget/ImagePreference;->mImage:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 82
    iget-object v0, p0, Lco/vine/android/widget/ImagePreference;->mImage:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 84
    :cond_0
    return-void
.end method

.method public setPreferenceBoundListener(Lco/vine/android/widget/ImagePreference$OnImagePreferenceBoundListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/ImagePreference$OnImagePreferenceBoundListener;

    .prologue
    .line 77
    iput-object p1, p0, Lco/vine/android/widget/ImagePreference;->mListener:Lco/vine/android/widget/ImagePreference$OnImagePreferenceBoundListener;

    .line 78
    return-void
.end method

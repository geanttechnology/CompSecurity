.class Lco/vine/android/widget/PopupEditText$DropDownListView;
.super Lco/vine/android/views/SdkListView;
.source "PopupEditText.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/PopupEditText;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DropDownListView"
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 499
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/views/SdkListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 500
    return-void
.end method


# virtual methods
.method public hasFocus()Z
    .locals 1

    .prologue
    .line 529
    const/4 v0, 0x1

    return v0
.end method

.method public hasWindowFocus()Z
    .locals 1

    .prologue
    .line 509
    const/4 v0, 0x1

    return v0
.end method

.method public isFocused()Z
    .locals 1

    .prologue
    .line 519
    const/4 v0, 0x1

    return v0
.end method

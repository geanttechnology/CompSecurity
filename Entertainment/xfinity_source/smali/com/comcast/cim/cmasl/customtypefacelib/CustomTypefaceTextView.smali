.class public Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;
.super Landroid/widget/TextView;
.source "CustomTypefaceTextView.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/customtypefacelib/TextStylable;


# instance fields
.field private final customTypefaceTextViewDelegate:Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 12
    new-instance v0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;

    invoke-direct {v0, p0}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;-><init>(Landroid/widget/TextView;)V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;->customTypefaceTextViewDelegate:Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;

    .line 20
    return-void
.end method


# virtual methods
.method public setTypefaceFamilyName(Ljava/lang/String;)V
    .locals 1
    .param p1, "typefaceFamilyName"    # Ljava/lang/String;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;->customTypefaceTextViewDelegate:Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->setTypefaceFamilyName(Ljava/lang/String;)V

    .line 34
    return-void
.end method

.method public setTypefaceStyle(I)V
    .locals 1
    .param p1, "style"    # I

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;->customTypefaceTextViewDelegate:Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->setTypefaceStyle(I)V

    .line 39
    return-void
.end method

.method public setupDelegate(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I
    .param p4, "typefaceManager"    # Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextView;->customTypefaceTextViewDelegate:Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->setup(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;)V

    .line 29
    return-void
.end method

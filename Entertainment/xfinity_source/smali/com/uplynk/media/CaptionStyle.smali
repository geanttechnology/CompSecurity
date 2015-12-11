.class public Lcom/uplynk/media/CaptionStyle;
.super Ljava/lang/Object;
.source "CaptionStyle.java"


# static fields
.field public static final EDGE_TYPE_DEPRESSED:I = 0x3

.field public static final EDGE_TYPE_DROP_SHADOW:I = 0x1

.field public static final EDGE_TYPE_NONE:I = 0x0

.field public static final EDGE_TYPE_RAISED:I = 0x2

.field public static final EDGE_TYPE_UNIFORM:I = 0x4

.field public static final TEXT_SIZE_LARGE:I = 0x96

.field public static final TEXT_SIZE_NORMAL:I = 0x64

.field public static final TEXT_SIZE_SMALL:I = 0x4b

.field public static final TEXT_SIZE_XLARGE:I = 0xc8

.field public static final TEXT_SIZE_XSMALL:I = 0x32


# instance fields
.field protected _backgroundColor:I

.field protected _edgeType:I

.field protected _textColor:I

.field protected _textSize:I

.field protected _typeface:Landroid/graphics/Typeface;

.field protected _windowColor:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    const/16 v0, 0x64

    iput v0, p0, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    .line 51
    const/4 v0, -0x1

    iput v0, p0, Lcom/uplynk/media/CaptionStyle;->_textColor:I

    .line 52
    const/high16 v0, -0x1000000

    iput v0, p0, Lcom/uplynk/media/CaptionStyle;->_backgroundColor:I

    .line 53
    sget-object v0, Landroid/graphics/Typeface;->MONOSPACE:Landroid/graphics/Typeface;

    iput-object v0, p0, Lcom/uplynk/media/CaptionStyle;->_typeface:Landroid/graphics/Typeface;

    .line 54
    iput v1, p0, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    .line 55
    iput v1, p0, Lcom/uplynk/media/CaptionStyle;->_windowColor:I

    .line 56
    return-void
.end method


# virtual methods
.method public getBackgroundColor()I
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/uplynk/media/CaptionStyle;->_backgroundColor:I

    return v0
.end method

.method public getEdgeType()I
    .locals 1

    .prologue
    .line 123
    iget v0, p0, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    return v0
.end method

.method public getTextColor()I
    .locals 1

    .prologue
    .line 77
    iget v0, p0, Lcom/uplynk/media/CaptionStyle;->_textColor:I

    return v0
.end method

.method public getTextSize()I
    .locals 1

    .prologue
    .line 60
    iget v0, p0, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    return v0
.end method

.method public getTypeface()Landroid/graphics/Typeface;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/uplynk/media/CaptionStyle;->_typeface:Landroid/graphics/Typeface;

    return-object v0
.end method

.method public getWindowColor()I
    .locals 1

    .prologue
    .line 139
    iget v0, p0, Lcom/uplynk/media/CaptionStyle;->_windowColor:I

    return v0
.end method

.method public setBackgroundColor(I)V
    .locals 0
    .param p1, "backgroundColor"    # I

    .prologue
    .line 102
    iput p1, p0, Lcom/uplynk/media/CaptionStyle;->_backgroundColor:I

    .line 103
    return-void
.end method

.method public setEdgeType(I)V
    .locals 0
    .param p1, "edgeType"    # I

    .prologue
    .line 133
    iput p1, p0, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    .line 134
    return-void
.end method

.method public setTextColor(I)V
    .locals 0
    .param p1, "textColor"    # I

    .prologue
    .line 87
    iput p1, p0, Lcom/uplynk/media/CaptionStyle;->_textColor:I

    .line 88
    return-void
.end method

.method public setTextSize(I)V
    .locals 1
    .param p1, "textSize"    # I

    .prologue
    .line 70
    const/16 v0, 0x32

    if-lt p1, v0, :cond_0

    const/16 v0, 0xc8

    if-le p1, v0, :cond_1

    .line 73
    :cond_0
    :goto_0
    return-void

    .line 72
    :cond_1
    iput p1, p0, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    goto :goto_0
.end method

.method public setTypeface(Landroid/graphics/Typeface;)V
    .locals 0
    .param p1, "typeface"    # Landroid/graphics/Typeface;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/uplynk/media/CaptionStyle;->_typeface:Landroid/graphics/Typeface;

    .line 119
    return-void
.end method

.method public setWindowColor(I)V
    .locals 0
    .param p1, "windowColor"    # I

    .prologue
    .line 149
    iput p1, p0, Lcom/uplynk/media/CaptionStyle;->_windowColor:I

    .line 150
    return-void
.end method

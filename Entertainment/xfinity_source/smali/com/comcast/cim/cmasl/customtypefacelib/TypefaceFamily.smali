.class public Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;
.super Ljava/lang/Object;
.source "TypefaceFamily.java"


# static fields
.field public static STYLE_BLACK:I

.field public static STYLE_BLACK_ITALIC:I

.field public static STYLE_BOLD:I

.field public static STYLE_BOLD_CONDENSED:I

.field public static STYLE_BOLD_CONDENSED_ITALIC:I

.field public static STYLE_BOLD_ITALIC:I

.field public static STYLE_CONDENSED:I

.field public static STYLE_CONDENSED_ITALIC:I

.field public static STYLE_CUSTOM_1:I

.field public static STYLE_CUSTOM_2:I

.field public static STYLE_ITALIC:I

.field public static STYLE_LIGHT:I

.field public static STYLE_LIGHT_ITALIC:I

.field public static STYLE_MEDIUM:I

.field public static STYLE_MEDIUM_CONDENSED:I

.field public static STYLE_MEDIUM_ITALIC:I

.field public static STYLE_REGULAR:I

.field public static STYLE_THIN:I

.field public static STYLE_THIN_ITALIC:I


# instance fields
.field private context:Landroid/content/Context;

.field fontsByStyle:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/graphics/Typeface;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const/4 v0, 0x0

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_REGULAR:I

    .line 15
    const/16 v0, 0x64

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BLACK:I

    .line 16
    const/16 v0, 0x65

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BLACK_ITALIC:I

    .line 18
    const/16 v0, 0xc8

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BOLD:I

    .line 19
    const/16 v0, 0xc9

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BOLD_CONDENSED:I

    .line 20
    const/16 v0, 0xca

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BOLD_CONDENSED_ITALIC:I

    .line 21
    const/16 v0, 0xcb

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BOLD_ITALIC:I

    .line 23
    const/16 v0, 0x12c

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_CONDENSED:I

    .line 24
    const/16 v0, 0x12d

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_CONDENSED_ITALIC:I

    .line 26
    const/16 v0, 0x190

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_ITALIC:I

    .line 28
    const/16 v0, 0x1f4

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_LIGHT:I

    .line 29
    const/16 v0, 0x1f5

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_LIGHT_ITALIC:I

    .line 31
    const/16 v0, 0x258

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_MEDIUM:I

    .line 32
    const/16 v0, 0x259

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_MEDIUM_CONDENSED:I

    .line 33
    const/16 v0, 0x25a

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_MEDIUM_ITALIC:I

    .line 35
    const/16 v0, 0x2bc

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_THIN:I

    .line 36
    const/16 v0, 0x2bd

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_THIN_ITALIC:I

    .line 38
    const/16 v0, 0x3e8

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_CUSTOM_1:I

    .line 39
    const/16 v0, 0x3e9

    sput v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_CUSTOM_2:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->fontsByStyle:Landroid/util/SparseArray;

    .line 45
    iput-object p1, p0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->context:Landroid/content/Context;

    .line 46
    return-void
.end method

.method public static getCustomStyleIdForAndroidStyle(I)I
    .locals 1
    .param p0, "style"    # I

    .prologue
    .line 62
    packed-switch p0, :pswitch_data_0

    .line 71
    sget v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_REGULAR:I

    :goto_0
    return v0

    .line 64
    :pswitch_0
    sget v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BOLD:I

    goto :goto_0

    .line 66
    :pswitch_1
    sget v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_BOLD_ITALIC:I

    goto :goto_0

    .line 68
    :pswitch_2
    sget v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->STYLE_ITALIC:I

    goto :goto_0

    .line 62
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public addTypeface(Ljava/lang/String;I)V
    .locals 2
    .param p1, "typefaceFileName"    # Ljava/lang/String;
    .param p2, "style"    # I

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->fontsByStyle:Landroid/util/SparseArray;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->createTypeface(Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {v0, p2, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 50
    return-void
.end method

.method protected createTypeface(Ljava/lang/String;)Landroid/graphics/Typeface;
    .locals 3
    .param p1, "typefaceFileName"    # Ljava/lang/String;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "fonts/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    return-object v0
.end method

.method public getTypeface(I)Landroid/graphics/Typeface;
    .locals 1
    .param p1, "variant"    # I

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->fontsByStyle:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Typeface;

    return-object v0
.end method

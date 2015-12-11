.class public Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;
.super Ljava/lang/Object;
.source "TypefaceManager.java"


# instance fields
.field private familyMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 10
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;->familyMap:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public addTypefaceFamily(Ljava/lang/String;Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;)V
    .locals 1
    .param p1, "familyName"    # Ljava/lang/String;
    .param p2, "family"    # Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;->familyMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 14
    return-void
.end method

.method public getTypeface(Ljava/lang/String;I)Landroid/graphics/Typeface;
    .locals 1
    .param p1, "typefaceName"    # Ljava/lang/String;
    .param p2, "variant"    # I

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;->familyMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;

    invoke-virtual {v0, p2}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->getTypeface(I)Landroid/graphics/Typeface;

    move-result-object v0

    return-object v0
.end method

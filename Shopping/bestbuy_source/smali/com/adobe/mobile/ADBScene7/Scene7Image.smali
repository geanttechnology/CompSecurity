.class public Lcom/adobe/mobile/ADBScene7/Scene7Image;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static _company:Ljava/lang/String;

.field private static _height:I

.field private static _width:I

.field private static s7Resource:Lcom/adobe/mobile/ADBScene7/S7CachedResource;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static GetAsset(Ljava/lang/String;Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 14
    sget-object v0, Lcom/adobe/mobile/ADBScene7/Scene7Image;->s7Resource:Lcom/adobe/mobile/ADBScene7/S7CachedResource;

    if-nez v0, :cond_0

    .line 15
    new-instance v0, Lcom/adobe/mobile/ADBScene7/S7CachedResource;

    invoke-direct {v0}, Lcom/adobe/mobile/ADBScene7/S7CachedResource;-><init>()V

    sput-object v0, Lcom/adobe/mobile/ADBScene7/Scene7Image;->s7Resource:Lcom/adobe/mobile/ADBScene7/S7CachedResource;

    .line 18
    :cond_0
    sget-object v0, Lcom/adobe/mobile/ADBScene7/Scene7Image;->s7Resource:Lcom/adobe/mobile/ADBScene7/S7CachedResource;

    sget-object v1, Lcom/adobe/mobile/ADBScene7/Scene7Image;->_company:Ljava/lang/String;

    sget-object v2, Lcom/adobe/mobile/ADBScene7/S7ResourceType;->S7ResourceTypeImage:Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    sget v3, Lcom/adobe/mobile/ADBScene7/Scene7Image;->_height:I

    sget v4, Lcom/adobe/mobile/ADBScene7/Scene7Image;->_width:I

    new-instance v6, Lcom/adobe/mobile/ADBScene7/Scene7Image$1;

    invoke-direct {v6, p1}, Lcom/adobe/mobile/ADBScene7/Scene7Image$1;-><init>(Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;)V

    move-object v5, p0

    invoke-virtual/range {v0 .. v6}, Lcom/adobe/mobile/ADBScene7/S7CachedResource;->GetS7CachedResource(Ljava/lang/String;Lcom/adobe/mobile/ADBScene7/S7ResourceType;IILjava/lang/String;Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;)V

    .line 26
    return-void
.end method

.method public static SetCompany(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 34
    sput-object p0, Lcom/adobe/mobile/ADBScene7/Scene7Image;->_company:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public static SetDimensions(II)V
    .locals 0

    .prologue
    .line 29
    sput p0, Lcom/adobe/mobile/ADBScene7/Scene7Image;->_height:I

    .line 30
    sput p1, Lcom/adobe/mobile/ADBScene7/Scene7Image;->_width:I

    .line 31
    return-void
.end method

.class public final enum Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;
.super Ljava/lang/Enum;
.source "AmazonWebKitFactory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/webkit/AmazonWebKitFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "SurfaceType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

.field public static final enum SURFACEVIEW:Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

.field public static final enum TEXTUREVIEW:Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 151
    new-instance v0, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    const-string/jumbo v1, "SURFACEVIEW"

    invoke-direct {v0, v1, v2, v2}, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->SURFACEVIEW:Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    .line 152
    new-instance v0, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    const-string/jumbo v1, "TEXTUREVIEW"

    invoke-direct {v0, v1, v3, v3}, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->TEXTUREVIEW:Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    .line 150
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    sget-object v1, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->SURFACEVIEW:Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->TEXTUREVIEW:Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->$VALUES:[Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "value"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 156
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 157
    iput p3, p0, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->value:I

    .line 158
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 150
    const-class v0, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;
    .locals 1

    .prologue
    .line 150
    sget-object v0, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->$VALUES:[Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    invoke-virtual {v0}, [Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    return-object v0
.end method


# virtual methods
.method public getValue()I
    .locals 1

    .prologue
    .line 161
    iget v0, p0, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->value:I

    return v0
.end method

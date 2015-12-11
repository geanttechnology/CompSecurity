.class public final enum Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;
.super Ljava/lang/Enum;
.source "AmazonWebSettings.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/webkit/AmazonWebSettings;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "TextSize"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

.field public static final enum LARGER:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

.field public static final enum LARGEST:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

.field public static final enum NORMAL:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

.field public static final enum SMALLER:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

.field public static final enum SMALLEST:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 20
    new-instance v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    const-string/jumbo v1, "LARGER"

    invoke-direct {v0, v1, v2}, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->LARGER:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    new-instance v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    const-string/jumbo v1, "LARGEST"

    invoke-direct {v0, v1, v3}, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->LARGEST:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    new-instance v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    const-string/jumbo v1, "NORMAL"

    invoke-direct {v0, v1, v4}, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->NORMAL:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    new-instance v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    const-string/jumbo v1, "SMALLER"

    invoke-direct {v0, v1, v5}, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->SMALLER:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    new-instance v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    const-string/jumbo v1, "SMALLEST"

    invoke-direct {v0, v1, v6}, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->SMALLEST:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    sget-object v1, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->LARGER:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->LARGEST:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->NORMAL:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->SMALLER:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->SMALLEST:Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->$VALUES:[Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 20
    const-class v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    return-object v0
.end method

.method public static values()[Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;
    .locals 1

    .prologue
    .line 20
    sget-object v0, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->$VALUES:[Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    invoke-virtual {v0}, [Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;

    return-object v0
.end method

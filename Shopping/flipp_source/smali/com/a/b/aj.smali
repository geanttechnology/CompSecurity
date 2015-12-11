.class public final enum Lcom/a/b/aj;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a/b/aj;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/a/b/aj;

.field public static final enum b:Lcom/a/b/aj;

.field public static final enum c:Lcom/a/b/aj;

.field private static final synthetic e:[Lcom/a/b/aj;


# instance fields
.field final d:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 512
    new-instance v0, Lcom/a/b/aj;

    const-string v1, "MEMORY"

    const v2, -0xff0100

    invoke-direct {v0, v1, v3, v2}, Lcom/a/b/aj;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/a/b/aj;->a:Lcom/a/b/aj;

    .line 513
    new-instance v0, Lcom/a/b/aj;

    const-string v1, "DISK"

    const/16 v2, -0x100

    invoke-direct {v0, v1, v4, v2}, Lcom/a/b/aj;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/a/b/aj;->b:Lcom/a/b/aj;

    .line 514
    new-instance v0, Lcom/a/b/aj;

    const-string v1, "NETWORK"

    const/high16 v2, -0x10000

    invoke-direct {v0, v1, v5, v2}, Lcom/a/b/aj;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/a/b/aj;->c:Lcom/a/b/aj;

    .line 511
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/a/b/aj;

    sget-object v1, Lcom/a/b/aj;->a:Lcom/a/b/aj;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a/b/aj;->b:Lcom/a/b/aj;

    aput-object v1, v0, v4

    sget-object v1, Lcom/a/b/aj;->c:Lcom/a/b/aj;

    aput-object v1, v0, v5

    sput-object v0, Lcom/a/b/aj;->e:[Lcom/a/b/aj;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 518
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 519
    iput p3, p0, Lcom/a/b/aj;->d:I

    .line 520
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/a/b/aj;
    .locals 1

    .prologue
    .line 511
    const-class v0, Lcom/a/b/aj;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a/b/aj;

    return-object v0
.end method

.method public static values()[Lcom/a/b/aj;
    .locals 1

    .prologue
    .line 511
    sget-object v0, Lcom/a/b/aj;->e:[Lcom/a/b/aj;

    invoke-virtual {v0}, [Lcom/a/b/aj;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a/b/aj;

    return-object v0
.end method

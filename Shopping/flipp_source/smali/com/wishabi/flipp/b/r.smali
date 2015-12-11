.class public final enum Lcom/wishabi/flipp/b/r;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/b/r;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/wishabi/flipp/b/r;

.field public static final enum b:Lcom/wishabi/flipp/b/r;

.field private static final synthetic d:[Lcom/wishabi/flipp/b/r;


# instance fields
.field final c:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 122
    new-instance v0, Lcom/wishabi/flipp/b/r;

    const-string v1, "OPEN"

    invoke-direct {v0, v1, v2, v2}, Lcom/wishabi/flipp/b/r;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/wishabi/flipp/b/r;->a:Lcom/wishabi/flipp/b/r;

    .line 123
    new-instance v0, Lcom/wishabi/flipp/b/r;

    const-string v1, "ENGAGEMENT"

    invoke-direct {v0, v1, v3, v3}, Lcom/wishabi/flipp/b/r;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/wishabi/flipp/b/r;->b:Lcom/wishabi/flipp/b/r;

    .line 121
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/wishabi/flipp/b/r;

    sget-object v1, Lcom/wishabi/flipp/b/r;->a:Lcom/wishabi/flipp/b/r;

    aput-object v1, v0, v2

    sget-object v1, Lcom/wishabi/flipp/b/r;->b:Lcom/wishabi/flipp/b/r;

    aput-object v1, v0, v3

    sput-object v0, Lcom/wishabi/flipp/b/r;->d:[Lcom/wishabi/flipp/b/r;

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
    .line 127
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 128
    iput p3, p0, Lcom/wishabi/flipp/b/r;->c:I

    .line 129
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wishabi/flipp/b/r;
    .locals 1

    .prologue
    .line 121
    const-class v0, Lcom/wishabi/flipp/b/r;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/b/r;

    return-object v0
.end method

.method public static values()[Lcom/wishabi/flipp/b/r;
    .locals 1

    .prologue
    .line 121
    sget-object v0, Lcom/wishabi/flipp/b/r;->d:[Lcom/wishabi/flipp/b/r;

    invoke-virtual {v0}, [Lcom/wishabi/flipp/b/r;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/b/r;

    return-object v0
.end method

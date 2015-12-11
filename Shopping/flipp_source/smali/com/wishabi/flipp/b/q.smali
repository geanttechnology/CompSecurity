.class public final enum Lcom/wishabi/flipp/b/q;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/b/q;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/wishabi/flipp/b/q;

.field public static final enum b:Lcom/wishabi/flipp/b/q;

.field public static final enum c:Lcom/wishabi/flipp/b/q;

.field public static final enum d:Lcom/wishabi/flipp/b/q;

.field public static final enum e:Lcom/wishabi/flipp/b/q;

.field private static final synthetic h:[Lcom/wishabi/flipp/b/q;


# instance fields
.field final f:I

.field final g:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 168
    new-instance v0, Lcom/wishabi/flipp/b/q;

    const-string v1, "OPEN"

    const-string v2, "open"

    invoke-direct {v0, v1, v3, v3, v2}, Lcom/wishabi/flipp/b/q;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/b/q;->a:Lcom/wishabi/flipp/b/q;

    .line 169
    new-instance v0, Lcom/wishabi/flipp/b/q;

    const-string v1, "BARCODE"

    const-string v2, "barcode"

    invoke-direct {v0, v1, v4, v4, v2}, Lcom/wishabi/flipp/b/q;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/b/q;->b:Lcom/wishabi/flipp/b/q;

    .line 170
    new-instance v0, Lcom/wishabi/flipp/b/q;

    const-string v1, "ADD"

    const-string v2, "add"

    invoke-direct {v0, v1, v5, v5, v2}, Lcom/wishabi/flipp/b/q;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/b/q;->c:Lcom/wishabi/flipp/b/q;

    .line 171
    new-instance v0, Lcom/wishabi/flipp/b/q;

    const-string v1, "ADD_MATCHED"

    const-string v2, "addMatched"

    invoke-direct {v0, v1, v6, v6, v2}, Lcom/wishabi/flipp/b/q;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/b/q;->d:Lcom/wishabi/flipp/b/q;

    .line 172
    new-instance v0, Lcom/wishabi/flipp/b/q;

    const-string v1, "SEND"

    const-string v2, "send"

    invoke-direct {v0, v1, v7, v7, v2}, Lcom/wishabi/flipp/b/q;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/b/q;->e:Lcom/wishabi/flipp/b/q;

    .line 167
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/wishabi/flipp/b/q;

    sget-object v1, Lcom/wishabi/flipp/b/q;->a:Lcom/wishabi/flipp/b/q;

    aput-object v1, v0, v3

    sget-object v1, Lcom/wishabi/flipp/b/q;->b:Lcom/wishabi/flipp/b/q;

    aput-object v1, v0, v4

    sget-object v1, Lcom/wishabi/flipp/b/q;->c:Lcom/wishabi/flipp/b/q;

    aput-object v1, v0, v5

    sget-object v1, Lcom/wishabi/flipp/b/q;->d:Lcom/wishabi/flipp/b/q;

    aput-object v1, v0, v6

    sget-object v1, Lcom/wishabi/flipp/b/q;->e:Lcom/wishabi/flipp/b/q;

    aput-object v1, v0, v7

    sput-object v0, Lcom/wishabi/flipp/b/q;->h:[Lcom/wishabi/flipp/b/q;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 177
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 178
    iput p3, p0, Lcom/wishabi/flipp/b/q;->f:I

    .line 179
    iput-object p4, p0, Lcom/wishabi/flipp/b/q;->g:Ljava/lang/String;

    .line 180
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wishabi/flipp/b/q;
    .locals 1

    .prologue
    .line 167
    const-class v0, Lcom/wishabi/flipp/b/q;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/b/q;

    return-object v0
.end method

.method public static values()[Lcom/wishabi/flipp/b/q;
    .locals 1

    .prologue
    .line 167
    sget-object v0, Lcom/wishabi/flipp/b/q;->h:[Lcom/wishabi/flipp/b/q;

    invoke-virtual {v0}, [Lcom/wishabi/flipp/b/q;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/b/q;

    return-object v0
.end method

.class public final enum Lcom/a/a/u;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/a/a/u;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/a/a/u;

.field public static final enum b:Lcom/a/a/u;

.field public static final enum c:Lcom/a/a/u;

.field private static final synthetic d:[Lcom/a/a/u;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 22
    new-instance v0, Lcom/a/a/u;

    const-string v1, "CACHE"

    invoke-direct {v0, v1, v2}, Lcom/a/a/u;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a/a/u;->a:Lcom/a/a/u;

    .line 29
    new-instance v0, Lcom/a/a/u;

    const-string v1, "CONDITIONAL_CACHE"

    invoke-direct {v0, v1, v3}, Lcom/a/a/u;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a/a/u;->b:Lcom/a/a/u;

    .line 32
    new-instance v0, Lcom/a/a/u;

    const-string v1, "NETWORK"

    invoke-direct {v0, v1, v4}, Lcom/a/a/u;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/a/a/u;->c:Lcom/a/a/u;

    .line 19
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/a/a/u;

    sget-object v1, Lcom/a/a/u;->a:Lcom/a/a/u;

    aput-object v1, v0, v2

    sget-object v1, Lcom/a/a/u;->b:Lcom/a/a/u;

    aput-object v1, v0, v3

    sget-object v1, Lcom/a/a/u;->c:Lcom/a/a/u;

    aput-object v1, v0, v4

    sput-object v0, Lcom/a/a/u;->d:[Lcom/a/a/u;

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
    .line 19
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/a/a/u;
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/a/a/u;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/a/a/u;

    return-object v0
.end method

.method public static values()[Lcom/a/a/u;
    .locals 1

    .prologue
    .line 19
    sget-object v0, Lcom/a/a/u;->d:[Lcom/a/a/u;

    invoke-virtual {v0}, [Lcom/a/a/u;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/a/a/u;

    return-object v0
.end method


# virtual methods
.method public final a()Z
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/a/a/u;->b:Lcom/a/a/u;

    if-eq p0, v0, :cond_0

    sget-object v0, Lcom/a/a/u;->c:Lcom/a/a/u;

    if-ne p0, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

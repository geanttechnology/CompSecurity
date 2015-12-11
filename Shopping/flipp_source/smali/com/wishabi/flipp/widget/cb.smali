.class public final enum Lcom/wishabi/flipp/widget/cb;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/widget/cb;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/wishabi/flipp/widget/cb;

.field public static final enum b:Lcom/wishabi/flipp/widget/cb;

.field public static final enum c:Lcom/wishabi/flipp/widget/cb;

.field private static final synthetic d:[Lcom/wishabi/flipp/widget/cb;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 34
    new-instance v0, Lcom/wishabi/flipp/widget/cb;

    const-string v1, "FEATURED"

    invoke-direct {v0, v1, v2}, Lcom/wishabi/flipp/widget/cb;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wishabi/flipp/widget/cb;->a:Lcom/wishabi/flipp/widget/cb;

    .line 35
    new-instance v0, Lcom/wishabi/flipp/widget/cb;

    const-string v1, "ALPHABETICAL"

    invoke-direct {v0, v1, v3}, Lcom/wishabi/flipp/widget/cb;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wishabi/flipp/widget/cb;->b:Lcom/wishabi/flipp/widget/cb;

    .line 36
    new-instance v0, Lcom/wishabi/flipp/widget/cb;

    const-string v1, "LATEST"

    invoke-direct {v0, v1, v4}, Lcom/wishabi/flipp/widget/cb;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/wishabi/flipp/widget/cb;->c:Lcom/wishabi/flipp/widget/cb;

    .line 33
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/wishabi/flipp/widget/cb;

    sget-object v1, Lcom/wishabi/flipp/widget/cb;->a:Lcom/wishabi/flipp/widget/cb;

    aput-object v1, v0, v2

    sget-object v1, Lcom/wishabi/flipp/widget/cb;->b:Lcom/wishabi/flipp/widget/cb;

    aput-object v1, v0, v3

    sget-object v1, Lcom/wishabi/flipp/widget/cb;->c:Lcom/wishabi/flipp/widget/cb;

    aput-object v1, v0, v4

    sput-object v0, Lcom/wishabi/flipp/widget/cb;->d:[Lcom/wishabi/flipp/widget/cb;

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
    .line 33
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wishabi/flipp/widget/cb;
    .locals 1

    .prologue
    .line 33
    const-class v0, Lcom/wishabi/flipp/widget/cb;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/cb;

    return-object v0
.end method

.method public static values()[Lcom/wishabi/flipp/widget/cb;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/wishabi/flipp/widget/cb;->d:[Lcom/wishabi/flipp/widget/cb;

    invoke-virtual {v0}, [Lcom/wishabi/flipp/widget/cb;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/widget/cb;

    return-object v0
.end method

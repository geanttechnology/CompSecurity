.class public final enum Lcom/wishabi/flipp/b/u;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/b/u;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/wishabi/flipp/b/u;

.field private static final synthetic f:[Lcom/wishabi/flipp/b/u;


# instance fields
.field public b:Landroid/content/Context;

.field public c:Landroid/os/Handler;

.field public d:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Landroid/os/AsyncTask",
            "<***>;>;"
        }
    .end annotation
.end field

.field private e:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 25
    new-instance v0, Lcom/wishabi/flipp/b/u;

    const-string v1, "INSTANCE"

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/b/u;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/b/u;->a:Lcom/wishabi/flipp/b/u;

    .line 24
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/wishabi/flipp/b/u;

    const/4 v1, 0x0

    sget-object v2, Lcom/wishabi/flipp/b/u;->a:Lcom/wishabi/flipp/b/u;

    aput-object v2, v0, v1

    sput-object v0, Lcom/wishabi/flipp/b/u;->f:[Lcom/wishabi/flipp/b/u;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 24
    invoke-direct {p0, p1, v0}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 29
    iput v0, p0, Lcom/wishabi/flipp/b/u;->e:I

    .line 32
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/b/u;->d:Ljava/util/HashMap;

    .line 34
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/b/u;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/wishabi/flipp/b/u;->d:Ljava/util/HashMap;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wishabi/flipp/b/u;
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/wishabi/flipp/b/u;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/b/u;

    return-object v0
.end method

.method public static values()[Lcom/wishabi/flipp/b/u;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/wishabi/flipp/b/u;->f:[Lcom/wishabi/flipp/b/u;

    invoke-virtual {v0}, [Lcom/wishabi/flipp/b/u;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/b/u;

    return-object v0
.end method


# virtual methods
.method public final a(Ljava/lang/String;Lcom/wishabi/flipp/b/x;)I
    .locals 3

    .prologue
    .line 50
    if-nez p1, :cond_0

    .line 51
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 53
    :cond_0
    if-nez p1, :cond_1

    .line 54
    iget-object v0, p0, Lcom/wishabi/flipp/b/u;->c:Landroid/os/Handler;

    new-instance v1, Lcom/wishabi/flipp/b/w;

    invoke-direct {v1, p0, p2}, Lcom/wishabi/flipp/b/w;-><init>(Lcom/wishabi/flipp/b/u;Lcom/wishabi/flipp/b/x;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    const/4 v0, -0x1

    .line 81
    :goto_0
    return v0

    .line 56
    :cond_1
    iget v0, p0, Lcom/wishabi/flipp/b/u;->e:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/wishabi/flipp/b/u;->e:I

    .line 58
    new-instance v1, Lcom/wishabi/flipp/b/v;

    invoke-direct {v1, p0, p1, v0, p2}, Lcom/wishabi/flipp/b/v;-><init>(Lcom/wishabi/flipp/b/u;Ljava/lang/String;ILcom/wishabi/flipp/b/x;)V

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/wishabi/flipp/b/v;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

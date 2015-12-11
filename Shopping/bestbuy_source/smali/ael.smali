.class public Lael;
.super Ljava/lang/Object;


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Ljava/lang/String;

.field private final c:Lafj;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lafj",
            "<",
            "Laex;",
            ">;"
        }
    .end annotation
.end field

.field private final d:Ljava/lang/String;

.field private e:Laen;


# direct methods
.method private constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lafj;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lafj",
            "<",
            "Laex;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lael;->a:Landroid/content/Context;

    iput-object p2, p0, Lael;->b:Ljava/lang/String;

    iput-object p4, p0, Lael;->c:Lafj;

    const/4 v0, 0x0

    iput-object v0, p0, Lael;->e:Laen;

    iput-object p3, p0, Lael;->d:Ljava/lang/String;

    return-void
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lafj;)Lael;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lafj",
            "<",
            "Laex;",
            ">;)",
            "Lael;"
        }
    .end annotation

    new-instance v0, Lael;

    invoke-direct {v0, p0, p1, p2, p3}, Lael;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lafj;)V

    return-object v0
.end method

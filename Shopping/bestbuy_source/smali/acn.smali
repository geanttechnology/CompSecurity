.class public Lacn;
.super Ljava/lang/Object;


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Lafj;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lafj",
            "<",
            "Laex;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Landroid/content/Context;Lafj;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lafj",
            "<",
            "Laex;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lacn;->a:Landroid/content/Context;

    iput-object p2, p0, Lacn;->b:Lafj;

    return-void
.end method

.method public static a(Landroid/content/Context;Lafj;)Lacn;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lafj",
            "<",
            "Laex;",
            ">;)",
            "Lacn;"
        }
    .end annotation

    new-instance v0, Lacn;

    invoke-direct {v0, p0, p1}, Lacn;-><init>(Landroid/content/Context;Lafj;)V

    return-object v0
.end method

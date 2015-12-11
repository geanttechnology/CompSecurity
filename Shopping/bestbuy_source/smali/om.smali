.class public final Lom;
.super Ljava/lang/Object;


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private final b:Ltz;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    sget-object v0, Ltz;->a:Ljava/lang/String;

    sput-object v0, Lom;->a:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>(Lon;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ltz;

    invoke-static {p1}, Lon;->a(Lon;)Lua;

    move-result-object v1

    invoke-direct {v0, v1}, Ltz;-><init>(Lua;)V

    iput-object v0, p0, Lom;->b:Ltz;

    return-void
.end method

.method synthetic constructor <init>(Lon;Lom$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lom;-><init>(Lon;)V

    return-void
.end method


# virtual methods
.method public a()Ltz;
    .locals 1

    iget-object v0, p0, Lom;->b:Ltz;

    return-object v0
.end method

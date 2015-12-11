.class public final enum Lcom/amazon/profiling/NullProfilerImplementation;
.super Ljava/lang/Enum;
.source "NullProfilerImplementation.java"

# interfaces
.implements Lcom/amazon/profiling/ProfilerImplementation;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/profiling/NullProfilerImplementation;",
        ">;",
        "Lcom/amazon/profiling/ProfilerImplementation;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/profiling/NullProfilerImplementation;

.field public static final enum INSTANCE:Lcom/amazon/profiling/NullProfilerImplementation;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 7
    new-instance v0, Lcom/amazon/profiling/NullProfilerImplementation;

    const-string/jumbo v1, "INSTANCE"

    invoke-direct {v0, v1, v2}, Lcom/amazon/profiling/NullProfilerImplementation;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/profiling/NullProfilerImplementation;->INSTANCE:Lcom/amazon/profiling/NullProfilerImplementation;

    .line 4
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/profiling/NullProfilerImplementation;

    sget-object v1, Lcom/amazon/profiling/NullProfilerImplementation;->INSTANCE:Lcom/amazon/profiling/NullProfilerImplementation;

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/profiling/NullProfilerImplementation;->$VALUES:[Lcom/amazon/profiling/NullProfilerImplementation;

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
    .line 4
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/profiling/NullProfilerImplementation;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/profiling/NullProfilerImplementation;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/profiling/NullProfilerImplementation;

    return-object v0
.end method

.method public static values()[Lcom/amazon/profiling/NullProfilerImplementation;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/profiling/NullProfilerImplementation;->$VALUES:[Lcom/amazon/profiling/NullProfilerImplementation;

    invoke-virtual {v0}, [Lcom/amazon/profiling/NullProfilerImplementation;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/profiling/NullProfilerImplementation;

    return-object v0
.end method


# virtual methods
.method public closeScope(Lcom/amazon/profiling/ProfilerScope;)V
    .locals 0
    .param p1, "scope"    # Lcom/amazon/profiling/ProfilerScope;

    .prologue
    .line 18
    return-void
.end method

.method public createMethodProfilerScope(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;
    .locals 1
    .param p2, "scopeName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Lcom/amazon/profiling/ProfilerScope;"
        }
    .end annotation

    .prologue
    .line 23
    .local p1, "parent":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v0, Lcom/amazon/profiling/NullProfilerScope;->INSTANCE:Lcom/amazon/profiling/NullProfilerScope;

    return-object v0
.end method

.method public createProfilerScope(Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;
    .locals 1
    .param p1, "scopeName"    # Ljava/lang/String;

    .prologue
    .line 12
    sget-object v0, Lcom/amazon/profiling/NullProfilerScope;->INSTANCE:Lcom/amazon/profiling/NullProfilerScope;

    return-object v0
.end method

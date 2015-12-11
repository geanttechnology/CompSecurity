.class public final Lcom/google/android/gms/drive/metadata/internal/c;
.super Ljava/lang/Object;


# static fields
.field private static a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/drive/metadata/b",
            "<*>;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/google/android/gms/drive/metadata/internal/c;->a:Ljava/util/Map;

    sget-object v0, Lcom/google/android/gms/internal/hy;->a:Lcom/google/android/gms/drive/metadata/b;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/hy;->b:Lcom/google/android/gms/drive/metadata/b;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/hy;->c:Lcom/google/android/gms/drive/metadata/b;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/hy;->d:Lcom/google/android/gms/drive/metadata/b;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/hy;->e:Lcom/google/android/gms/drive/metadata/b;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/hy;->f:Lcom/google/android/gms/drive/metadata/b;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/hy;->g:Lcom/google/android/gms/drive/metadata/b;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/hy;->h:Lcom/google/android/gms/drive/metadata/a;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/ia;->c:Lcom/google/android/gms/drive/metadata/c;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/ia;->a:Lcom/google/android/gms/drive/metadata/c;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/ia;->b:Lcom/google/android/gms/drive/metadata/c;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    sget-object v0, Lcom/google/android/gms/internal/ia;->d:Lcom/google/android/gms/drive/metadata/c;

    invoke-static {v0}, Lcom/google/android/gms/drive/metadata/internal/c;->a(Lcom/google/android/gms/drive/metadata/b;)V

    return-void
.end method

.method public static a(Ljava/lang/String;)Lcom/google/android/gms/drive/metadata/b;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/drive/metadata/b",
            "<*>;"
        }
    .end annotation

    sget-object v0, Lcom/google/android/gms/drive/metadata/internal/c;->a:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/drive/metadata/b;

    return-object v0
.end method

.method private static a(Lcom/google/android/gms/drive/metadata/b;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/drive/metadata/b",
            "<*>;)V"
        }
    .end annotation

    sget-object v0, Lcom/google/android/gms/drive/metadata/internal/c;->a:Ljava/util/Map;

    iget-object v1, p0, Lcom/google/android/gms/drive/metadata/b;->a:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Duplicate field name registered: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/google/android/gms/drive/metadata/b;->a:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    sget-object v0, Lcom/google/android/gms/drive/metadata/internal/c;->a:Ljava/util/Map;

    iget-object v1, p0, Lcom/google/android/gms/drive/metadata/b;->a:Ljava/lang/String;

    invoke-interface {v0, v1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

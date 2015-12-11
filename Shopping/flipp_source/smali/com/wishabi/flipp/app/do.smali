.class public final enum Lcom/wishabi/flipp/app/do;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/wishabi/flipp/app/do;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/wishabi/flipp/app/do;

.field private static final c:Ljava/lang/String;

.field private static final synthetic d:[Lcom/wishabi/flipp/app/do;


# instance fields
.field b:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 16
    new-instance v0, Lcom/wishabi/flipp/app/do;

    const-string v1, "INSTANCE"

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/app/do;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/wishabi/flipp/app/do;->a:Lcom/wishabi/flipp/app/do;

    .line 14
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/wishabi/flipp/app/do;

    const/4 v1, 0x0

    sget-object v2, Lcom/wishabi/flipp/app/do;->a:Lcom/wishabi/flipp/app/do;

    aput-object v2, v0, v1

    sput-object v0, Lcom/wishabi/flipp/app/do;->d:[Lcom/wishabi/flipp/app/do;

    .line 18
    const-class v0, Lcom/wishabi/flipp/app/do;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/app/do;->c:Ljava/lang/String;

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
    .line 14
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 29
    const/4 v0, -0x1

    iput v0, p0, Lcom/wishabi/flipp/app/do;->b:I

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/wishabi/flipp/app/do;
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/wishabi/flipp/app/do;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/do;

    return-object v0
.end method

.method public static values()[Lcom/wishabi/flipp/app/do;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/wishabi/flipp/app/do;->d:[Lcom/wishabi/flipp/app/do;

    invoke-virtual {v0}, [Lcom/wishabi/flipp/app/do;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/wishabi/flipp/app/do;

    return-object v0
.end method


# virtual methods
.method public final a()I
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v0, -0x1

    .line 33
    iget v1, p0, Lcom/wishabi/flipp/app/do;->b:I

    if-eq v1, v0, :cond_1

    .line 34
    iget v0, p0, Lcom/wishabi/flipp/app/do;->b:I

    .line 71
    :cond_0
    :goto_0
    return v0

    .line 36
    :cond_1
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v1

    .line 37
    if-eqz v1, :cond_0

    .line 41
    const-string v0, "last_onboarding_version"

    invoke-interface {v1, v0, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/wishabi/flipp/app/do;->b:I

    .line 46
    iget v0, p0, Lcom/wishabi/flipp/app/do;->b:I

    if-nez v0, :cond_2

    .line 47
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 48
    const-string v2, "has_seen_shoplist"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 51
    if-eqz v2, :cond_3

    .line 53
    const/4 v0, 0x2

    iput v0, p0, Lcom/wishabi/flipp/app/do;->b:I

    .line 54
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "last_onboarding_version"

    iget v2, p0, Lcom/wishabi/flipp/app/do;->b:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 71
    :cond_2
    :goto_1
    iget v0, p0, Lcom/wishabi/flipp/app/do;->b:I

    goto :goto_0

    .line 59
    :cond_3
    if-eqz v0, :cond_2

    .line 62
    const/4 v0, 0x1

    iput v0, p0, Lcom/wishabi/flipp/app/do;->b:I

    .line 63
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "last_onboarding_version"

    iget v2, p0, Lcom/wishabi/flipp/app/do;->b:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_1
.end method

.method public final b()[I
    .locals 1

    .prologue
    .line 96
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/do;->a()I

    move-result v0

    .line 97
    packed-switch v0, :pswitch_data_0

    .line 108
    const/4 v0, 0x5

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    :goto_0
    return-object v0

    .line 99
    :pswitch_0
    const/4 v0, 0x3

    new-array v0, v0, [I

    fill-array-data v0, :array_1

    goto :goto_0

    .line 104
    :pswitch_1
    const/4 v0, 0x2

    new-array v0, v0, [I

    fill-array-data v0, :array_2

    goto :goto_0

    .line 97
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch

    .line 108
    :array_0
    .array-data 4
        0x7f03003d
        0x7f03003e
        0x7f03003f
        0x7f030040
        0x7f030041
    .end array-data

    .line 99
    :array_1
    .array-data 4
        0x7f03003d
        0x7f03003e
        0x7f030041
    .end array-data

    .line 104
    :array_2
    .array-data 4
        0x7f03003d
        0x7f030041
    .end array-data
.end method

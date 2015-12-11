.class public final enum Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;
.super Ljava/lang/Enum;
.source "BundleListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/adapters/BundleListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

.field public static final enum VIEW_BUNDLE:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

.field public static final enum VIEW_UNAVAILABLE_ITEMS:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 31
    new-instance v0, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    const-string v1, "VIEW_BUNDLE"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;->VIEW_BUNDLE:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    .line 32
    new-instance v0, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    const-string v1, "VIEW_UNAVAILABLE_ITEMS"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;->VIEW_UNAVAILABLE_ITEMS:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    .line 30
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    sget-object v1, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;->VIEW_BUNDLE:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;->VIEW_UNAVAILABLE_ITEMS:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    aput-object v1, v0, v3

    sput-object v0, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;->$VALUES:[Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

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
    .line 30
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 30
    const-class v0, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;->$VALUES:[Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    invoke-virtual {v0}, [Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    return-object v0
.end method

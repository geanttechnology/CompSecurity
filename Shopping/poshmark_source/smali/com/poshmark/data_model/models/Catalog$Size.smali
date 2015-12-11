.class public Lcom/poshmark/data_model/models/Catalog$Size;
.super Ljava/lang/Object;
.source "Catalog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/Catalog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Size"
.end annotation


# instance fields
.field public longName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "long"
    .end annotation
.end field

.field public shortName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "short"
    .end annotation
.end field

.field final synthetic this$0:Lcom/poshmark/data_model/models/Catalog;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/Catalog;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/poshmark/data_model/models/Catalog$Size;->this$0:Lcom/poshmark/data_model/models/Catalog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

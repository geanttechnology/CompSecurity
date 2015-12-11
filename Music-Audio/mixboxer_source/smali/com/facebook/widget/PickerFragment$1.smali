.class Lcom/facebook/widget/PickerFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/facebook/widget/GraphObjectAdapter$Filter;


# instance fields
.field final synthetic this$0:Lcom/facebook/widget/PickerFragment;


# direct methods
.method constructor <init>(Lcom/facebook/widget/PickerFragment;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/facebook/widget/PickerFragment$1;->this$0:Lcom/facebook/widget/PickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public includeItem(Lcom/facebook/model/GraphObject;)Z
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/facebook/widget/PickerFragment$1;->this$0:Lcom/facebook/widget/PickerFragment;

    invoke-virtual {v0, p1}, Lcom/facebook/widget/PickerFragment;->filterIncludesItem(Lcom/facebook/model/GraphObject;)Z

    move-result v0

    return v0
.end method

.method public bridge synthetic includeItem(Ljava/lang/Object;)Z
    .locals 1

    .prologue
    .line 118
    check-cast p1, Lcom/facebook/model/GraphObject;

    invoke-virtual {p0, p1}, Lcom/facebook/widget/PickerFragment$1;->includeItem(Lcom/facebook/model/GraphObject;)Z

    move-result v0

    return v0
.end method
